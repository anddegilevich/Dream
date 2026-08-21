plugins {
    alias(libs.plugins.project.feature.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.domain.model.core.api)
            api(projects.shared.feature.album.domain.model.artifact.test)
            api(projects.shared.feature.artist.domain.model.core.test)
            api(projects.shared.feature.track.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.model.core.test"
    }
}
