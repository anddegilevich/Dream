plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            // Logger
            implementation(projects.shared.logger)

            // Core
            implementation(projects.shared.resource.impl)
            implementation(projects.shared.core.storage.impl)
            implementation(projects.shared.core.client.impl)
            implementation(projects.shared.core.service.impl)
            implementation(projects.shared.core.db.impl)
            implementation(projects.shared.core.toast.impl)
            implementation(projects.shared.core.filepicker.impl)

            // Template
            implementation(projects.shared.template.component)

            // Feature
            implementation(projects.shared.feature.artist.core.impl)
            implementation(projects.shared.feature.artist.design.impl)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.di"
}