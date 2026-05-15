plugins {
    alias(libs.plugins.project.template.ui.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.track.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.ui.api"
    }
}