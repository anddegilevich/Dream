plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.track.source.api)
            api(projects.shared.feature.track.domain.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.track.domain.impl"
}