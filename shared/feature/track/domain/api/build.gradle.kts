plugins {
    alias(libs.plugins.project.feature.domain.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.data.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.domain.api"
    }
}