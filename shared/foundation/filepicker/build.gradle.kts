plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.foundation.filepicker"
}