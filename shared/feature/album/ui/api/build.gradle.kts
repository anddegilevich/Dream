plugins {
    alias(libs.plugins.project.feature.ui.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.album.domain.model.artifact)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.ui.api"
    }
}