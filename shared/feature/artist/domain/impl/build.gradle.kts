plugins {
    alias(libs.plugins.project.feature.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.domain.api)
            implementation(projects.shared.feature.album.domain.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.artist.data.test)
            implementation(projects.shared.feature.artist.domain.model.core.test)
            implementation(projects.shared.feature.album.data.test)
            implementation(projects.shared.feature.album.domain.model.artifact.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.domain.impl"
    }
}