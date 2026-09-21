plugins {
    alias(libs.plugins.project.feature.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.playlist.data.api)
            implementation(projects.shared.feature.playlist.data.mapper.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.playlist.data.mapper.test)
            implementation(projects.shared.feature.playlist.domain.model.artifact.test)
            implementation(projects.shared.feature.playlist.domain.model.core.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.playlist.data.impl"
    }
}
