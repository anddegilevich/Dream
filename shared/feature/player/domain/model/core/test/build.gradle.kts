plugins {
    alias(libs.plugins.project.feature.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.player.domain.model.core.api)
            api(projects.shared.feature.track.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.player.model.core.test"
    }
}
