plugins {
    alias(libs.plugins.project.feature.ui.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.playlist.domain.model.core.api)
            api(projects.shared.feature.track.ui.api)
            api(projects.shared.feature.album.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.playlist.ui.api"
    }
}
