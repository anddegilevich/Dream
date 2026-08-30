plugins {
    alias(libs.plugins.project.feature.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.playlist.domain.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.playlist.data.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.playlist.domain.impl"
    }
}
