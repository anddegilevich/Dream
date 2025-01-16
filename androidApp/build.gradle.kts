plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.app)
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

    flavorDimensions.add("server")
    productFlavors {
        create("mock") {
            dimension = "server"
            applicationIdSuffix = ".mock"
        }

        create("prod") {
            dimension = "server"
        }
    }
}

