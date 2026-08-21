plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.decompose)
            api(projects.shared.foundation.abstraction)
            api(projects.shared.feature.album.domain.model.artifact.api)
            api(projects.shared.feature.artist.domain.model.artifact.api)
            api(projects.shared.feature.track.domain.model.artifact.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.navigation.api"
    }
}