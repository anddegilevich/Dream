plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.template.model.api)
            api(projects.shared.feature.artist.model.artifact.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.track.model.artifact.api"
}