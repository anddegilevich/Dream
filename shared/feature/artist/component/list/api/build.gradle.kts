plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.common.component)
            api(projects.shared.compose.foundation)
            api(projects.shared.feature.artist.compose)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.component.list.api"
}