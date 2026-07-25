plugins {
    alias(libs.plugins.project.feature.data.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.domain.model.core.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.data.api"
    }
}