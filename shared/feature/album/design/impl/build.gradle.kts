plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.design.api)
            implementation(projects.shared.feature.album.model.artifact.api)
            implementation(projects.shared.feature.artist.design.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.album.design.impl"
}