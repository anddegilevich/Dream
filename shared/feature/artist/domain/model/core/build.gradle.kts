plugins {
    alias(libs.plugins.project.template.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.domain.model.artifact)
            api(projects.shared.feature.image.domain.model.artifact)
            api(projects.shared.feature.track.domain.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.model.core"
    }
}