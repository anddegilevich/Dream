plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.component.details.api)
            implementation(projects.shared.core.datetime.api)
            implementation(projects.shared.feature.album.domain.api)
            implementation(projects.shared.feature.artist.domain.api)
            implementation(projects.shared.feature.album.ui.api)
            implementation(projects.shared.feature.artist.ui.api)
            implementation(projects.shared.feature.track.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.component.details.impl"
    }
}