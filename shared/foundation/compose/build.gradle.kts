plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.collections.immutable)
            api(projects.shared.foundation.coroutine)
            api(projects.shared.foundation.abstraction)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.foundation.compose"
}