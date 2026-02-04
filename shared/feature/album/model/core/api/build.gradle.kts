plugins {
    alias(libs.plugins.project.template.model.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.model.artifact.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.album.model.core.api"
    }
}