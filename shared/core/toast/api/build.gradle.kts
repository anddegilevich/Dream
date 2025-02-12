plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.model)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.toast.api"
}