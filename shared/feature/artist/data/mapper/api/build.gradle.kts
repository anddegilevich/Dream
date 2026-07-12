plugins {
    alias(libs.plugins.project.feature.data.mapper.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.domain.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.data.mapper.api"
    }
}
