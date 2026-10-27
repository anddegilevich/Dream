import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import java.net.URI

plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
    alias(libs.plugins.openapi.generator)
    alias(libs.plugins.project.ktor)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.network.api)
            api(projects.shared.foundation.abstraction)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.service.api"
    }
}

/**
 * Downloads Spotify's OpenAPI schema and fixes places where it does not match real API responses:
 * - `TrackObject | EpisodeObject` oneOf unions become plain `TrackObject` refs. The generator emits an
 *   unusable polymorphic sealed class for them, and episodes are not requested (`additional_types` is omitted).
 * - `CurrentlyPlayingContextObject.timestamp` is a Unix millisecond timestamp, so it needs `int64`.
 */
val patchOpenApiSpec by tasks.registering {
    description = "Downloads the Spotify OpenAPI schema and patches it to match real API responses before generation."

    val specUrl = "https://developer.spotify.com/reference/web-api/open-api-schema.yaml"
    val patchedSpec = layout.buildDirectory.file("openapi/open-api-schema.yaml")
    outputs.file(patchedSpec)
    outputs.upToDateWhen { false }

    doLast {
        val mapper = YAMLMapper()
        val trackRef = "#/components/schemas/TrackObject"
        val episodeRef = "#/components/schemas/EpisodeObject"

        fun refTo(ref: String): MutableList<Any?> = mutableListOf(mutableMapOf<String, Any?>("\$ref" to ref))

        fun Map<*, *>.isTrackOrEpisodeUnion(): Boolean {
            val refs = (get("oneOf") as? List<*>)?.mapNotNull { (it as? Map<*, *>)?.get("\$ref") }?.toSet()
            return refs == setOf(trackRef, episodeRef)
        }

        fun Any?.replaceTrackOrEpisodeUnions() {
            when (this) {
                is MutableMap<*, *> -> {
                    @Suppress("UNCHECKED_CAST")
                    val node = this as MutableMap<String, Any?>
                    if (node.isTrackOrEpisodeUnion()) {
                        node.keys.removeAll(listOf("oneOf", "discriminator", "x-spotify-docs-type"))
                        node["allOf"] = refTo(trackRef)
                    }
                    node.values.forEach { it.replaceTrackOrEpisodeUnions() }
                }
                is List<*> -> forEach { it.replaceTrackOrEpisodeUnions() }
                else -> Unit
            }
        }

        @Suppress("UNCHECKED_CAST")
        fun Any?.child(key: String): MutableMap<String, Any?> = (this as Map<String, Any?>)[key] as MutableMap<String, Any?>

        val root = URI(specUrl).toURL().openStream().use { mapper.readValue(it, LinkedHashMap::class.java) }
        root.replaceTrackOrEpisodeUnions()

        root.child("components")
            .child("schemas")
            .child("CurrentlyPlayingContextObject")
            .child("properties")
            .child("timestamp")["format"] = "int64"

        patchedSpec.get().asFile.apply {
            parentFile.mkdirs()
            mapper.writeValue(this, root)
        }
    }
}

tasks.named("openApiGenerate") {
    dependsOn(patchOpenApiSpec)
}

openApiGenerate {
    generatorName = "kotlin"
    skipValidateSpec = true
    inputSpec.set(layout.buildDirectory.file("openapi/open-api-schema.yaml").get().asFile.absolutePath)
    outputDir.set("$projectDir")
    packageName = "and.degilevich.dream.shared.core.service.api.generated"
    modelPackage = "and.degilevich.dream.shared.core.service.api.generated.model"
    apiPackage = "and.degilevich.dream.shared.core.service.api.generated.api"
    ignoreFileOverride.set("$projectDir/.openapi-generator-ignore")

    configOptions.apply {
        put("sourceFolder", "src/commonMain/kotlin")
        put("collectionType", "list")
        put("dateLibrary", "string")
        put("enumPropertyNaming", "UPPERCASE")
        put("library", "multiplatform")
    }
    generateApiTests = false
    generateModelTests = false
}

// To generate api use
// ./gradlew :shared:core:service:api:openApiGenerate