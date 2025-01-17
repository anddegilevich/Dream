plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.model.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.source.api"
}