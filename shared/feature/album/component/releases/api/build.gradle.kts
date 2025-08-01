plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.template.component.api)
            api(projects.shared.feature.album.design.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.album.component.releases.api"
}