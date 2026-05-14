plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.decompose)
            api(projects.shared.foundation.abstraction)
            api(projects.shared.feature.album.model.artifact)
            api(projects.shared.feature.artist.model.artifact)
            api(projects.shared.feature.track.model.artifact)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.navigation.api"
    }
}