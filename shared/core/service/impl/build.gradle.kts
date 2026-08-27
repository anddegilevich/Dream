plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
    alias(libs.plugins.project.ktor)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.di)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.service.api)
            implementation(projects.shared.config)
            implementation(projects.shared.core.storage.api)
            implementation(projects.shared.core.crypto.api)
            implementation(projects.shared.core.webauth.api)
            implementation(projects.shared.foundation.abstraction)
        }
        commonTest.dependencies {
            implementation(libs.ktor.client.mock)
            implementation(projects.shared.core.crypto.test)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.service.impl"
    }
}