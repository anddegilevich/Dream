plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.model.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.domain.api"
}