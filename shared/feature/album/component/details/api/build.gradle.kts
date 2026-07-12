plugins {
    alias(libs.plugins.project.feature.component.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.ui.api)
            api(projects.shared.feature.artist.ui.api)
            api(projects.shared.feature.track.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.component.details.api"
    }
}