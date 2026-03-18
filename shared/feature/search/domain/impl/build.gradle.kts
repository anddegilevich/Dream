plugins {
    alias(libs.plugins.project.template.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.search.source.api)
            implementation(projects.shared.feature.artist.source.api)
            implementation(projects.shared.feature.album.source.api)
            implementation(projects.shared.feature.track.source.api)
            api(projects.shared.feature.search.domain.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.domain.impl"
    }
}