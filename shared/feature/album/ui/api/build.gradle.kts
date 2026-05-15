plugins {
    alias(libs.plugins.project.template.ui.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.album.model.artifact)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.ui.api"
    }
}