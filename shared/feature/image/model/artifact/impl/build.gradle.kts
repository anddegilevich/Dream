plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.service.api)
            api(projects.shared.feature.image.model.artifact.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.image.model.artifact.impl"
}