plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.toast.api)
            api(projects.shared.foundation.model)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.toast.impl"
}