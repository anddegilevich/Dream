plugins {
    alias(libs.plugins.project.feature.ui.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.player.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.player.ui.test"
    }
}
