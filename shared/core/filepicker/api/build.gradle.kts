plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.abstraction)
            api(projects.shared.foundation.filepicker)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.filepicker.api"
}