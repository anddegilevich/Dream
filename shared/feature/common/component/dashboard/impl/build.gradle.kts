plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.common.component.dashboard.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.common.component.dashboard.impl"
}