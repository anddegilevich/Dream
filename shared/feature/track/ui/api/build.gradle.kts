plugins {
    alias(libs.plugins.project.feature.ui.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.track.domain.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.ui.api"
    }
}