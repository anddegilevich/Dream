plugins {
    alias(libs.plugins.project.template.source.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.source.api)
            implementation(projects.shared.feature.image.source.api)
            implementation(projects.shared.feature.artist.source.api)
            implementation(projects.shared.feature.track.source.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.album.source.impl"
}