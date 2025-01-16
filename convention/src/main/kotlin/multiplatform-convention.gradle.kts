import and.degilevich.dream.convention.common.libs
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("detekt-convention")
    id("android-convention")
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(libs().versions.java.get()))
        }
    }

    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        applyDefaultHierarchyTemplate()
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions {
        // suppress expect/actual warning
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}