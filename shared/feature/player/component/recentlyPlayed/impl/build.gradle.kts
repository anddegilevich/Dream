plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.player.component.recentlyPlayed.api)
            implementation(projects.shared.feature.player.domain.api)
            implementation(projects.shared.feature.playlist.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl"
    }
}
