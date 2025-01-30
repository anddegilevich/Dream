plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.model)
            api(projects.shared.feature.artist.model.artifact)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.track.model.artifact"
}