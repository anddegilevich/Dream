plugins {
    alias(libs.plugins.project.template.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.model.artifact)
            api(projects.shared.feature.image.model.artifact)
            api(projects.shared.feature.track.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.model.core"
    }
}