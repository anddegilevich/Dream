plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.model.artifact)
            api(projects.shared.feature.image.model.artifact)
            api(projects.shared.feature.album.model.core)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.track.model.artifact"
}