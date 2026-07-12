plugins {
    alias(libs.plugins.project.feature.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.ui.api)
            implementation(projects.shared.feature.album.domain.model.artifact)
            implementation(projects.shared.feature.artist.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.ui.impl"
    }
}