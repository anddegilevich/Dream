plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.template.component.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.component.search.api"
}