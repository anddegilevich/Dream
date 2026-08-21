plugins {
    alias(libs.plugins.project.feature.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.ui.api)
            implementation(projects.shared.feature.artist.ui.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.artist.ui.test)
            implementation(projects.shared.feature.image.domain.model.artifact.test)
            implementation(projects.shared.feature.artist.domain.model.core.test)
            implementation(projects.shared.feature.album.domain.model.artifact.test)
            implementation(projects.shared.feature.track.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.ui.impl"
    }
}