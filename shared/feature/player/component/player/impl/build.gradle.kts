plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.player.component.player.api)
            implementation(projects.shared.feature.player.domain.api)
            implementation(projects.shared.feature.player.ui.api)
            implementation(projects.shared.feature.track.ui.api)
            implementation(projects.shared.feature.album.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.player.component.player.impl"
    }
}
