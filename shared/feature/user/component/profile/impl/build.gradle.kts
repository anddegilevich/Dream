plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.user.component.profile.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.user.component.profile.impl"
}