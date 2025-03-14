plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.ktor)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.primitive)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.client.api"
}