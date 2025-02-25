import com.codingfeline.buildkonfig.compiler.FieldSpec
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.buildkonfig)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.ktor)
    alias(libs.plugins.project.koin)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.client.api)
            implementation(projects.shared.foundation.model)
            implementation(projects.shared.foundation.serialization)
            implementation(projects.shared.core.storage.api)
            implementation(projects.shared.core.logger)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.client.impl"
}

buildkonfig {
    packageName = "and.degilevich.dream.shared.core.client.impl"

    val clientIdField = "CLIENT_ID"
    val clientSecretField = "CLIENT_SECRET"
    val localProperties = Properties().apply {
        load(FileInputStream("${rootDir}/local.properties"))
    }
    val clientId = localProperties.getProperty(clientIdField)
    val clientSecret = localProperties.getProperty(clientSecretField)

    defaultConfigs { }

    defaultConfigs("prod") {
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = clientIdField,
            value = clientId
        )
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = clientSecretField,
            value = clientSecret
        )
    }

    defaultConfigs("mock") {
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = clientIdField,
            value = "mockClientId"
        )
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = clientSecretField,
            value = "mockClientSecret"
        )
    }
}