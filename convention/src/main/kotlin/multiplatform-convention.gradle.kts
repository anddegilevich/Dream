import and.degilevich.dream.convention.common.libs

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("detekt-convention")
    id("android-convention")
}

kotlin {
    applyDefaultHierarchyTemplate()
    androidTarget()
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