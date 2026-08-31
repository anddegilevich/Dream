plugins {
    alias(libs.plugins.project.feature.data.mapper.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.playlist.domain.model.core.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.playlist.data.mapper.api"
    }
}
