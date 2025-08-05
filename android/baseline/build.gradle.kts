import kotlin.math.max

plugins {
    alias(libs.plugins.android.test)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.project.android)
    alias(libs.plugins.baselineprofile)
}

android {
    namespace = "and.degilevich.dream.baseline"

    defaultConfig {
        minSdk = max(28, libs.versions.android.min.sdk.get().toInt())
        targetSdk = libs.versions.android.target.sdk.get().toInt()
    }

    targetProjectPath = projects.android.app.path

    val variantFlavorDimension = "variant"
    flavorDimensions += variantFlavorDimension
    productFlavors {
        create("prod") {
            dimension = variantFlavorDimension
        }
        create("mock") {
            dimension = variantFlavorDimension
        }
    }
}

baselineProfile {
    useConnectedDevices = false
}

dependencies {
    implementation(libs.androidx.junit)
    implementation(libs.androidx.espresso.core)
    implementation(libs.androidx.uiautomator)
    implementation(libs.androidx.benchmark.macro.junit4)
}

androidComponents {
    onVariants { variant ->
        val artifactsLoader = variant.artifacts.getBuiltArtifactsLoader()
        val applicationIdProvider = variant.testedApks.map { testedApk ->
            artifactsLoader.load(testedApk)?.applicationId.orEmpty()
        }
        variant.instrumentationRunnerArguments.put(
            "targetAppId",
            applicationIdProvider
        )
    }
}