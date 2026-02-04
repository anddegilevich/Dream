plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.serialization)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.foundation.serialization)
            implementation(projects.shared.core.service.api)
            implementation(projects.shared.core.db.api)
            implementation(projects.shared.core.storage.api)
            api(projects.shared.template.source.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.template.source.impl"
    }
}