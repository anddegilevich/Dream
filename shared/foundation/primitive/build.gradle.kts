plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.collections.immutable)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.foundation.primitive"
}