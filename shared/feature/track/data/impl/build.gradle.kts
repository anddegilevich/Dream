plugins {
    alias(libs.plugins.project.template.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.data.api)
            implementation(projects.shared.feature.track.data.api)
            implementation(projects.shared.feature.album.data.api)
            implementation(projects.shared.feature.artist.data.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.data.impl"
    }
}