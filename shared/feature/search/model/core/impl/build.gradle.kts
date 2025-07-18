plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.service.api)
            api(projects.shared.feature.search.model.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.model.core.impl"
}