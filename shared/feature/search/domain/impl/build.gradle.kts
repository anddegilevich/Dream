plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.search.source.api)
            api(projects.shared.feature.search.domain.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.domain.impl"
}