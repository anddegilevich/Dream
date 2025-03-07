plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.template.component)
            api(projects.shared.feature.artist.design.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.component.list.api"
}