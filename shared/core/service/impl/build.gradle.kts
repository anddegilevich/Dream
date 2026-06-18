plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
    alias(libs.plugins.project.ktor)
    alias(libs.plugins.project.di)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.service.api)
            implementation(projects.shared.config)
            implementation(projects.shared.core.storage.api)
            implementation(projects.shared.foundation.abstraction)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.service.impl"
    }
}