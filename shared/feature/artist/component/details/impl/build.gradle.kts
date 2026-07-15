plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.artist.domain.api)
            implementation(projects.shared.feature.artist.ui.api)
            implementation(projects.shared.feature.album.ui.api)
            api(projects.shared.feature.artist.component.details.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.component.details.impl"
    }
}