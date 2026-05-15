plugins {
    alias(libs.plugins.project.template.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.search.data.api)
            implementation(projects.shared.feature.artist.data.api)
            implementation(projects.shared.feature.album.data.api)
            implementation(projects.shared.feature.track.data.api)
            api(projects.shared.feature.search.domain.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.domain.impl"
    }
}