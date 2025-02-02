plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.compose.theme)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.compose.design"
}