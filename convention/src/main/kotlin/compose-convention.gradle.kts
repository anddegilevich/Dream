import and.degilevich.dream.convention.common.libs

plugins {
    id("multiplatform-convention")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.compose")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(libs().androidx.lifecycle.runtime.compose)
        }
        androidMain.dependencies {
            implementation(compose.uiTooling)
            implementation(libs().androidx.activity.compose)
        }
    }
}