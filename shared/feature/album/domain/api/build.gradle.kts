plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.model.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.album.domain.api"
}