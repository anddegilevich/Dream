plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
    alias(libs.plugins.openapi.generator)
}

kotlin {
    android {
        namespace = "and.degilevich.dream.shared.core.service.api"
    }
}

openApiGenerate {
    generatorName = "kotlin"
    skipValidateSpec = true
    inputSpec.set("https://developer.spotify.com/reference/web-api/open-api-schema.yaml")
    outputDir.set(projectDir)
    packageName = "and.degilevich.dream.shared.core.service.api.generated"
    configOptions.apply {
        put("sourceFolder", "src/commonMain/kotlin")
        put("collectionType", "list")
        put("dateLibrary", "string")
        put("enumPropertyNaming", "UPPERCASE")
        put("library", "multiplatform")
        put("requestDateConverter", "toString")
        put("serializationLibrary", "kotlinx_serialization")
    }
    generateApiTests = false
    generateModelTests = false
    generateApiDocumentation = false
    generateModelDocumentation = false
}

// To generate api use
// ./gradlew :shared:core:service:api:openApiGenerate