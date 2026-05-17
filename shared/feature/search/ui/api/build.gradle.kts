plugins {
    alias(libs.plugins.project.template.ui.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.search.domain.model.core)
            implementation(projects.shared.feature.artist.ui.api)
            implementation(projects.shared.feature.album.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.ui.api"
    }
}