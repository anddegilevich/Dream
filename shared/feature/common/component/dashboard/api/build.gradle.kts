plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.template.component.api)
            api(projects.shared.feature.album.component.releases.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.common.component.dashboard.api"
}