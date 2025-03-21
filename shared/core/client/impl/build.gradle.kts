plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.ktor)
    alias(libs.plugins.project.koin)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.foundation.abstraction)
            implementation(projects.shared.foundation.serialization)
            implementation(projects.shared.config)
            implementation(projects.shared.logger)
            api(projects.shared.core.client.api)
            implementation(projects.shared.core.storage.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.client.impl"
}