plugins {
    alias(libs.plugins.project.feature.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.ui.impl"
    }
}