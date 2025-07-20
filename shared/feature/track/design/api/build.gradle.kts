plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.abstraction)
            api(projects.shared.design.system)
            implementation(projects.shared.feature.track.model.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.track.design.api"
}