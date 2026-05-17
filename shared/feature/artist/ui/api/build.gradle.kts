plugins {
    alias(libs.plugins.project.template.ui.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.artist.domain.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.ui.api"
    }
}