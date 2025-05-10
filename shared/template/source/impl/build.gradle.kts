plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.foundation.serialization)
            api(projects.shared.core.service.api)
            api(projects.shared.core.db.api)
            implementation(projects.shared.core.storage.api)
            api(projects.shared.template.source.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.template.source.api"
}