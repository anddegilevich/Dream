import and.degilevich.dream.convention.common.compileSdk
import and.degilevich.dream.convention.common.javaVersion
import and.degilevich.dream.convention.common.libs
import and.degilevich.dream.convention.common.minSdk
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
    id("detekt-convention")
}

kotlin {
    jvmToolchain(javaVersion())

    applyDefaultHierarchyTemplate()

    android {
        compileSdk = compileSdk()
        minSdk = minSdk()
        compileSdk = compileSdk()

        packaging {
            resources.excludes.apply {
                add("META-INF/*.kotlin_module")
                add("META-INF/AL2.0")
                add("META-INF/LGPL2.1")
            }
        }
        androidResources {
            enable = true
        }
        withHostTestBuilder {}.configure {
            isIncludeAndroidResources = true
        }
        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            execution = "HOST"
        }
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(javaVersion().toString()))
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    sourceSets {
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
        getByName("androidHostTest").dependencies {
            implementation(libs().kotlin.test.junit)
        }
        getByName("androidDeviceTest")
    }
}