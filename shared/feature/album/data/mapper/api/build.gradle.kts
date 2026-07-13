plugins {
    alias(libs.plugins.project.feature.data.mapper.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.domain.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.data.mapper.api"
    }
}
