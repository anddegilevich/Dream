plugins {
    alias(libs.plugins.project.template.domain.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.model.core.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.artist.domain.api"
    }
}