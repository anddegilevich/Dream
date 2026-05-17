plugins {
    alias(libs.plugins.project.template.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.domain.model.core)
            api(projects.shared.feature.artist.domain.model.core)
            api(projects.shared.feature.album.domain.model.artifact)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.model.core"
    }
}