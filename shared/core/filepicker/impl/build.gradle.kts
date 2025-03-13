plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.filepicker.api)
            implementation(projects.shared.foundation.dispatcher)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.filepicker.impl"
}