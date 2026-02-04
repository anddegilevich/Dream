import and.degilevich.dream.convention.common.compileSdk
import and.degilevich.dream.convention.common.javaVersion
import and.degilevich.dream.convention.common.minSdk
import and.degilevich.dream.convention.common.libs
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinBaseExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinBasePlugin

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
    id("detekt-convention")
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidLibrary {
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
            implementation(libs().kotlin.test.common)
            implementation(libs().kotlin.test.annotations.common)
        }

        androidUnitTest.dependencies {
            implementation(libs().kotlin.test.junit)
        }
    }
}

plugins.withType<KotlinBasePlugin> {
    configure<KotlinBaseExtension> {
        jvmToolchain(javaVersion())
    }
}