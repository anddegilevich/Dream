plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.artist.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.component.details.impl"
}