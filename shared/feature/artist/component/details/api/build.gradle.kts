plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.common.component)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.component.details.api"
}