plugins {
    alias(libs.plugins.project.feature.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.domain.api)
            implementation(projects.shared.feature.artist.domain.api)
            implementation(projects.shared.feature.album.domain.api)
            implementation(projects.shared.feature.track.domain.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.domain.impl"
    }
}