plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.model.artifact)
            api(projects.shared.feature.artist.model.artifact)
            api(projects.shared.feature.image.model.artifact)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.album.model.artifact"
}