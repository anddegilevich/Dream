plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.design.api)
            implementation(projects.shared.feature.search.model.core.api)
            implementation(projects.shared.feature.artist.design.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.design.impl"
}