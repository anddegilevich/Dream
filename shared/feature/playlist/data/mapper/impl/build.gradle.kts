plugins {
    alias(libs.plugins.project.feature.data.mapper.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.playlist.data.mapper.api)
            implementation(projects.shared.feature.image.data.mapper.api)
            implementation(projects.shared.feature.track.data.mapper.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.image.data.mapper.test)
            implementation(projects.shared.feature.image.domain.model.artifact.test)
            implementation(projects.shared.feature.playlist.data.mapper.test)
            implementation(projects.shared.feature.playlist.domain.model.artifact.test)
            implementation(projects.shared.feature.playlist.domain.model.core.test)
            implementation(projects.shared.feature.track.data.mapper.test)
            implementation(projects.shared.feature.track.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.playlist.data.mapper.impl"
    }
}
