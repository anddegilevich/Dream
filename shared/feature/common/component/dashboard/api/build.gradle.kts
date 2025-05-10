plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.template.component.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.common.component.dashboard.api"
}