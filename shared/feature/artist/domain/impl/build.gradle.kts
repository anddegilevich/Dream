plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.artist.source.api)
            api(projects.shared.feature.artist.domain.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.domain.impl"
}