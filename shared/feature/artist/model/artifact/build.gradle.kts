plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.model)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.model.artifact"
}