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
            isMinifyEnabled = false
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isDebuggable = true
        }
    }
}

