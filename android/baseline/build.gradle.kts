import com.android.build.api.dsl.ManagedVirtualDevice
import kotlin.math.max

plugins {
    alias(libs.plugins.android.test)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.project.android)
    alias(libs.plugins.baselineprofile)
}

val virtualDeviceName = "pixel8Api35"

android {
    namespace = "and.degilevich.dream.baseline"

    defaultConfig {
        minSdk = max(28, libs.versions.android.min.sdk.get().toInt())
        targetSdk = libs.versions.android.target.sdk.get().toInt()
    }

    targetProjectPath = projects.android.app.identityPath.path

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

    testOptions.managedDevices.devices {
        create<ManagedVirtualDevice>(virtualDeviceName) {
            device = "Pixel 8"
            apiLevel = 35
            systemImageSource = "google"
        }
    }
}

baselineProfile {
    managedDevices += virtualDeviceName
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