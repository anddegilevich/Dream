plugins {
    alias(libs.plugins.project.template.data.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.domain.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.data.api"
    }
}