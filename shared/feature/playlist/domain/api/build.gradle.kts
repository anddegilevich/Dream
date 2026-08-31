plugins {
    alias(libs.plugins.project.feature.domain.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.playlist.data.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.playlist.domain.api"
    }
}
