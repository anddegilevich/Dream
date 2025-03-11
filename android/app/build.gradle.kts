plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.project.android)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.baselineprofile)
}

android {
    namespace = "and.degilevich.dream"

    defaultConfig {
        applicationId = "and.degilevich.dream"
        targetSdk = libs.versions.android.target.sdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("debug") {
            isDefault = true
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug") //FIXME: Add signing
            matchingFallbacks.add("debug")
        }
    }

    val variantFlavorDimension = "variant"
    flavorDimensions += variantFlavorDimension
    productFlavors {
        create("prod") {
            dimension = variantFlavorDimension
            isDefault = true
            manifestPlaceholders["applicationName"] = "@string/app_name"
        }
        create("mock") {
            dimension = variantFlavorDimension
            applicationIdSuffix = ".mock"
            manifestPlaceholders["applicationName"] = "@string/app_name_mock"
        }
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.android)

    implementation(libs.androidx.activity.compose)

    implementation(libs.androidx.core.splashscreen)

    implementation(libs.bundles.decompose)
    implementation(libs.decompose.extensions.android)

    implementation(projects.shared.app.impl)

    implementation(libs.androidx.profileinstaller)
    baselineProfile(projects.android.baseline)
}

