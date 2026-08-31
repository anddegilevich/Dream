plugins {
    alias(libs.plugins.project.feature.data.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.playlist.domain.model.core.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.playlist.data.api"
    }
}
