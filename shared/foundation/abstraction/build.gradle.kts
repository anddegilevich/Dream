plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.primitive)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.foundation.abstraction"
}