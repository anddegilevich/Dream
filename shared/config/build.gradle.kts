import com.codingfeline.buildkonfig.compiler.FieldSpec
import java.io.FileInputStream
import java.util.Properties
import java.util.regex.Pattern

plugins {
    alias(libs.plugins.buildkonfig)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    android {
        namespace = "and.degilevich.dream.shared.config"
    }
}

val prodFlavor = "prod"
val mockFlavor = "mock"

project.extra.set(
    "buildkonfig.flavor",
    currentBuildVariant(
        variants = setOf(prodFlavor, mockFlavor),
        default = prodFlavor
    )
)

buildkonfig {
    packageName = "and.degilevich.dream"
    exposeObjectWithName = "SharedBuildConfig"

    val variantField = "VARIANT"
    val clientIdField = "CLIENT_ID"
    val authAuthorizeUrlField = "AUTH_AUTHORIZE_URL"
    val authTokenUrlField = "AUTH_TOKEN_URL"
    val apiBaseUrlField = "API_BASE_URL"
    val redirectUriField = "REDIRECT_URI"

    defaultConfigs { }

    defaultConfigs(prodFlavor) {
        val localProperties = Properties().apply {
            load(FileInputStream("${rootDir}/local.properties"))
        }
        val clientId = localProperties.getProperty(clientIdField)

        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = variantField,
            value = prodFlavor
        )
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = authAuthorizeUrlField,
            value = "https://accounts.spotify.com/authorize"
        )
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = authTokenUrlField,
            value = "https://accounts.spotify.com/api/token"
        )
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = redirectUriField,
            value = "and.degilevich.dream://callback"
        )
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = apiBaseUrlField,
            value = "https://api.spotify.com/v1/"
        )
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = clientIdField,
            value = clientId
        )
    }

    // FIXME: Add proper mock implementation
    defaultConfigs(mockFlavor) {
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = variantField,
            value = mockFlavor
        )
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = authAuthorizeUrlField,
            value = ""
        )
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = authTokenUrlField,
            value = ""
        )
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = redirectUriField,
            value = ""
        )
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = apiBaseUrlField,
            value = ""
        )
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = clientIdField,
            value = ""
        )
    }
}

private fun Project.currentBuildVariant(
    variants: Set<String>,
    default: String
): String {
    return getAndroidBuildVariantOrNull(variants = variants) ?: getIosBuildVariantOrNull()
        .toString()
        .takeIf { it in variants } ?: default
}

private fun Project.getAndroidBuildVariantOrNull(variants: Set<String>): String? {
    val taskRequestsStr = gradle.startParameter.taskRequests.toString()
    val pattern: Pattern = if (taskRequestsStr.contains("assemble")) {
        Pattern.compile("assemble(\\w+)(Release|Debug)")
    } else {
        Pattern.compile("bundle(\\w+)(Release|Debug)")
    }

    val matcher = pattern.matcher(taskRequestsStr)
    val variant = if (matcher.find()) matcher.group(1).lowercase() else null
    return if (variant in variants) {
        variant
    } else {
        null
    }
}

private fun getIosBuildVariantOrNull(): String? {
    return System.getenv()["VARIANT"]
}