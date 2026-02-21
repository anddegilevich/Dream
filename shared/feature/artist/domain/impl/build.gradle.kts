plugins {
    alias(libs.plugins.project.template.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.artist.source.api)
            implementation(projects.shared.feature.album.source.api)
            implementation(projects.shared.feature.track.source.api)
            api(projects.shared.feature.artist.domain.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.artist.domain.impl"
    }
}