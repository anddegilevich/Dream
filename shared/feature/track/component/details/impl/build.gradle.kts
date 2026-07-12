plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.track.domain.api)
            implementation(projects.shared.feature.album.ui.api)
            implementation(projects.shared.feature.artist.ui.api)
            api(projects.shared.feature.track.component.details.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.component.details.impl"
    }
}