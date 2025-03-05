plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.resource.api)
            api(projects.shared.foundation.compose)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.design.theme"
}