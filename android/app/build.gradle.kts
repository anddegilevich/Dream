plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.decompose)

            implementation(projects.shared.app.impl)
        }

        androidMain.dependencies {
            implementation(libs.decompose.extensions.android)
            implementation(libs.androidx.core.splashscreen)
        }
    }
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
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug") //FIXME: Add signing
        }
        getByName("debug") {
            isDefault = true
            isDebuggable = true
        }
    }

    flavorDimensions.add("server")
    productFlavors {
        create("mock") {
            dimension = "server"
            manifestPlaceholders["applicationName"] = "@string/app_name_mock"
        }

        create("prod") {
            dimension = "server"
            isDefault = true
            manifestPlaceholders["applicationName"] = "@string/app_name"
        }
    }
}

