plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.navigation.api)
            implementation(projects.shared.foundation.dispatcher)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.navigation.impl"
}