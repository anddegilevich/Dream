plugins {
    alias(libs.plugins.project.feature.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.domain.api)
            implementation(projects.shared.feature.search.domain.api)
        }
        commonTest.dependencies {
            implementation(projects.shared.feature.album.data.test)
            implementation(projects.shared.feature.album.domain.model.core.test)
            implementation(projects.shared.feature.album.domain.model.artifact.test)
            implementation(projects.shared.feature.search.data.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.domain.impl"
    }
}