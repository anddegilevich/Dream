plugins {
    alias(libs.plugins.project.feature.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.playlist.ui.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.playlist.domain.model.artifact.test)
            implementation(projects.shared.feature.image.domain.model.artifact.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.playlist.ui.impl"
    }
}
