plugins {
    alias(libs.plugins.project.feature.data.mapper.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.data.mapper.api)
            implementation(projects.shared.feature.artist.data.mapper.api)
            implementation(projects.shared.feature.album.data.mapper.api)
            implementation(projects.shared.feature.track.data.mapper.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.search.data.mapper.test)
            implementation(projects.shared.feature.artist.data.mapper.test)
            implementation(projects.shared.feature.album.data.mapper.test)
            implementation(projects.shared.feature.album.domain.model.artifact.test)
            implementation(projects.shared.feature.track.data.mapper.test)
            implementation(projects.shared.feature.search.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.data.mapper.impl"
    }
}
