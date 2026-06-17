plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
    alias(libs.plugins.openapi.generator)
    alias(libs.plugins.project.ktor)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.client.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.service.api"
    }
}

openApiGenerate {
    generatorName = "kotlin"
    skipValidateSpec = true
    inputSpec.set("https://developer.spotify.com/reference/web-api/open-api-schema.yaml")
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