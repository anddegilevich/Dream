plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.decompose.extensions.compose)

            implementation(projects.shared.foundation.decompose.compose)

            api(projects.shared.foundation.decompose.component)

            api(projects.shared.navigation.api)

            api(projects.shared.feature.artist.component.details.api)
            api(projects.shared.feature.artist.component.list.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.app.api"
}