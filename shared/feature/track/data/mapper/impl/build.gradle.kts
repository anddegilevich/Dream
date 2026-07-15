plugins {
    alias(libs.plugins.project.feature.data.mapper.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.data.mapper.api)
            implementation(projects.shared.feature.image.data.mapper.api)
            implementation(projects.shared.feature.artist.data.mapper.api)
            implementation(projects.shared.feature.album.data.mapper.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.data.mapper.impl"
    }
}
