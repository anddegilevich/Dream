plugins {
    alias(libs.plugins.project.template.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.domain.api)
            implementation(projects.shared.feature.album.data.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.artist.domain.impl"
    }
}