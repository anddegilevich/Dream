plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.widget.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.widget.impl"
}