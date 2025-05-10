plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.service.api)
            api(projects.shared.feature.track.model.artifact.api)
            api(projects.shared.feature.image.model.artifact.api)
            api(projects.shared.feature.album.model.artifact.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.track.model.core.api"
}