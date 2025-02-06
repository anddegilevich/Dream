plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.service.api)
            api(projects.shared.foundation.model)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.image.model.artifact"
}