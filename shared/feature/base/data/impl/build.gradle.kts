plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.serialization)
    alias(libs.plugins.project.di)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.foundation.serialization)
            implementation(projects.shared.core.service.api)
            implementation(projects.shared.core.db.api)
            implementation(projects.shared.core.storage.api)
            api(projects.shared.feature.base.data.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.base.data.impl"
    }
}