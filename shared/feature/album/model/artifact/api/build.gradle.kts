plugins {
    alias(libs.plugins.project.template.model.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.model.artifact.api)
            api(projects.shared.feature.artist.model.artifact.api)
            api(projects.shared.feature.image.model.artifact.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.album.model.artifact.api"
}