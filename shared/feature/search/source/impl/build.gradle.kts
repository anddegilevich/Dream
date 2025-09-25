plugins {
    alias(libs.plugins.project.template.source.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.source.api)
            implementation(projects.shared.feature.track.source.api)
            implementation(projects.shared.feature.artist.source.api)
            implementation(projects.shared.feature.album.source.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.source.impl"
}