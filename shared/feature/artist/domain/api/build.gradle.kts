plugins {
    alias(libs.plugins.project.template.domain.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.data.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.domain.api"
    }
}