plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.koin)
    alias(libs.plugins.project.ktor)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.error.api)
            implementation(projects.shared.core.resource.api)
            implementation(projects.shared.core.logger)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.error.impl"
}