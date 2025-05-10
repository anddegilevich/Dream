plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.abstraction)
            implementation(projects.shared.template.source.api)
            api(projects.shared.feature.artist.model.core.api)
            api(projects.shared.feature.track.model.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.source.api"
}