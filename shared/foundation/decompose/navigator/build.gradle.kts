plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.bundles.decompose)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.foundation.decompose.navigator"
}