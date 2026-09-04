plugins {
    alias(libs.plugins.project.feature.data.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.player.data.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.player.data.test"
    }
}
