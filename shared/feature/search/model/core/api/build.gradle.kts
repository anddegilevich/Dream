plugins {
    alias(libs.plugins.project.template.model.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.model.core.api)
            api(projects.shared.feature.artist.model.core.api)
            api(projects.shared.feature.album.model.artifact.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.model.core.api"
}