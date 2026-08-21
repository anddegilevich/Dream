plugins {
    alias(libs.plugins.project.feature.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.ui.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.track.domain.model.artifact.test)
            implementation(projects.shared.feature.artist.domain.model.artifact.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.ui.impl"
    }
}