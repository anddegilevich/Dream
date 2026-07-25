plugins {
    alias(libs.plugins.project.feature.ui.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.ui.test"
    }
}
