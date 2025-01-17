plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.source.api)
            implementation(projects.shared.feature.artist.model.impl)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.source.impl"
}