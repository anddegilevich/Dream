plugins {
    alias(libs.plugins.project.feature.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.domain.api)
            implementation(projects.shared.feature.search.domain.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.domain.impl"
    }
}