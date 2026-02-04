plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.baselineprofile)
}

android {
    namespace = "and.degilevich.dream"
    compileSdk = libs.versions.android.compile.sdk.get().toInt()

    defaultConfig {
        applicationId = "and.degilevich.dream"
        targetSdk = libs.versions.android.target.sdk.get().toInt()
        minSdk = libs.versions.android.min.sdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        val javaVersion = JavaVersion.toVersion(libs.versions.java.get().toInt())
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    buildTypes {
        debug {
            isDefault = true
            isDebuggable = true
        }
        release {
            isMinifyEnabled = true
            isDebuggable = false
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
        compose = true
    }
}

dependencies {
    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.android)

    // Androidx
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.splashscreen)

    // Glance
    implementation(libs.bundles.glance)

    // Decompose
    implementation(libs.bundles.decompose)
    implementation(libs.decompose.extensions.android)

    // App
    implementation(projects.shared.app.impl)

    // Baseline profile
    implementation(libs.androidx.profileinstaller)
    baselineProfile(projects.android.baseline)
}

