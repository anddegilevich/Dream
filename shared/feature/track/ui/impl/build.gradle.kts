plugins {
    alias(libs.plugins.project.feature.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.ui.impl"
    }
}