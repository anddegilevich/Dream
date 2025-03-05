plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.model)
            api(projects.shared.design.system)
            implementation(projects.shared.feature.artist.model.core)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.compose"
}