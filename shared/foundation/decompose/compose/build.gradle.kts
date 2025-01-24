plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.bundles.decompose)
            api(libs.decompose.extensions.compose)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.foundation.decompose.compose"
}