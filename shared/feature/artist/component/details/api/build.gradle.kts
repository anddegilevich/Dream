plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.template.component.api)
            api(projects.shared.feature.artist.design.api)
            api(projects.shared.feature.album.design.api)
            api(projects.shared.feature.track.design.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.component.details.api"
}