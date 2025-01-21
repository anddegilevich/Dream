plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kvault)
            api(projects.shared.core.storage.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.storage.impl"
}