plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.service.api)
            api(projects.shared.foundation.abstraction)
            api(projects.shared.feature.track.model.core.api)
            api(projects.shared.feature.artist.model.core.api)
            api(projects.shared.feature.album.model.artifact.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.model.core.api"
}