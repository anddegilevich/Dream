plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.player.component.miniPlayer.api)
            implementation(projects.shared.feature.player.domain.api)
            implementation(projects.shared.feature.track.ui.api)
            implementation(projects.shared.feature.album.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.player.component.miniPlayer.impl"
    }
}
