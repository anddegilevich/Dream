plugins {
    alias(libs.plugins.project.feature.ui.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.domain.model.core.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.ui.api"
    }
}