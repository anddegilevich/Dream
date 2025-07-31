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
            implementation(projects.shared.feature.search.model.core.api)
            implementation(projects.shared.feature.artist.design.api)
            implementation(projects.shared.feature.album.design.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.design.api"
}