plugins {
    alias(libs.plugins.project.feature.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.data.api)
            implementation(projects.shared.feature.album.data.mapper.api)
            implementation(projects.shared.feature.artist.data.mapper.api)
            implementation(projects.shared.feature.track.data.mapper.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.data.impl"
    }
}