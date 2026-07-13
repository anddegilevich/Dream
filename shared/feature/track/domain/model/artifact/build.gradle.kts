plugins {
    alias(libs.plugins.project.feature.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.domain.model.artifact)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.model.artifact"
    }
}