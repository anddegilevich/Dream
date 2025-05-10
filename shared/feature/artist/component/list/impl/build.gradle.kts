plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.component.list.api)
            implementation(projects.shared.feature.artist.source.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.component.list.impl"
}