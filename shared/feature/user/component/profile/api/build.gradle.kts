plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.template.component)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.user.component.profile.api"
}