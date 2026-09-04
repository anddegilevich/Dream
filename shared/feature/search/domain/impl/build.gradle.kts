plugins {
    alias(libs.plugins.project.feature.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.domain.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.search.data.test)
            implementation(projects.shared.feature.search.domain.test)
            implementation(projects.shared.feature.artist.domain.model.core.test)
            implementation(projects.shared.feature.album.domain.model.artifact.test)
            implementation(projects.shared.feature.track.domain.model.core.test)
            implementation(projects.shared.feature.search.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.domain.impl"
    }
}
