plugins {
    alias(libs.plugins.project.feature.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.domain.model.artifact.api)
            api(projects.shared.feature.image.domain.model.artifact.api)
            api(projects.shared.feature.track.domain.model.core.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.model.core.api"
    }
}