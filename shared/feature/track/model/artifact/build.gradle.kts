plugins {
    alias(libs.plugins.project.template.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.model.artifact)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.model.artifact"
    }
}