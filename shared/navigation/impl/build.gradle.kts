plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.navigation.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.navigation.impl"
}