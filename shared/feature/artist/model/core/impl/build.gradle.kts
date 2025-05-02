plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.service.api)
            implementation(projects.shared.core.db.api)
            api(projects.shared.feature.artist.model.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.model.core.impl"
}