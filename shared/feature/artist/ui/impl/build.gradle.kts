plugins {
    alias(libs.plugins.project.feature.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.ui.api)
            implementation(projects.shared.feature.artist.domain.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.ui.impl"
    }
}