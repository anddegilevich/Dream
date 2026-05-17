plugins {
    alias(libs.plugins.project.template.domain.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.domain.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.domain.api"
    }
}