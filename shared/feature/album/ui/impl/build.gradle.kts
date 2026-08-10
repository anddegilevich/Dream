plugins {
    alias(libs.plugins.project.feature.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.ui.api)
            implementation(projects.shared.feature.artist.ui.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.resource.test)
            implementation(projects.shared.feature.album.domain.model.artifact.test)
            implementation(projects.shared.feature.image.domain.model.artifact.test)
            implementation(projects.shared.feature.artist.ui.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.ui.impl"
    }
}