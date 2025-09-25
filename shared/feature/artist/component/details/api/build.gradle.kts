plugins {
    alias(libs.plugins.project.template.component.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.design.api)
            api(projects.shared.feature.album.design.api)
            api(projects.shared.feature.track.design.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.component.details.api"
}