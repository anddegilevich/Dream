plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.ktor)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.service.api)
            implementation(projects.shared.core.client.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.service.impl"
}