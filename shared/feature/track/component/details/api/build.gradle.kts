plugins {
    alias(libs.plugins.project.feature.component.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.ui.api)
            api(projects.shared.feature.artist.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.component.details.api"
    }
}