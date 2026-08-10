plugins {
    alias(libs.plugins.project.feature.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.data.api)
            implementation(projects.shared.feature.track.data.mapper.api)
            implementation(projects.shared.feature.album.data.mapper.api)
            implementation(projects.shared.feature.artist.data.mapper.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.track.data.mapper.test)
            implementation(projects.shared.feature.track.domain.model.core.test)
            implementation(projects.shared.feature.album.data.mapper.test)
            implementation(projects.shared.feature.artist.data.mapper.test)
            implementation(projects.shared.feature.album.domain.model.artifact.test)
            implementation(projects.shared.feature.artist.domain.model.artifact.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.data.impl"
    }
}