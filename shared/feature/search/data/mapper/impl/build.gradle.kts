plugins {
    alias(libs.plugins.project.template.data.mapper.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.data.mapper.api)
            implementation(projects.shared.feature.artist.data.mapper.api)
            implementation(projects.shared.feature.album.data.mapper.api)
            implementation(projects.shared.feature.track.data.mapper.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.data.mapper.impl"
    }
}
