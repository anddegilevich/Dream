plugins {
    alias(libs.plugins.project.template.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.model.core)
            api(projects.shared.feature.artist.model.core)
            api(projects.shared.feature.album.model.artifact)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.model.core"
    }
}