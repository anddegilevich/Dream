plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.model.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.track.domain.api"
}