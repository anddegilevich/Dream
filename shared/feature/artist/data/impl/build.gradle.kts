plugins {
    alias(libs.plugins.project.feature.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.data.api)
            implementation(projects.shared.feature.artist.data.mapper.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.data.impl"
    }
}