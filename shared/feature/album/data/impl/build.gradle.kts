plugins {
    alias(libs.plugins.project.feature.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.data.api)
            implementation(projects.shared.feature.album.data.mapper.api)
            implementation(projects.shared.feature.artist.data.mapper.api)
            implementation(projects.shared.feature.track.data.mapper.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.core.service.test)
            implementation(projects.shared.feature.album.data.mapper.test)
            implementation(projects.shared.feature.artist.data.mapper.test)
            implementation(projects.shared.feature.track.data.mapper.test)
            implementation(projects.shared.feature.album.domain.model.core.test)
            implementation(projects.shared.feature.artist.domain.model.artifact.test)
            implementation(projects.shared.feature.track.domain.model.artifact.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.data.impl"
    }
}