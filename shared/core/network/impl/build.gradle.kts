plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.ktor)
    alias(libs.plugins.project.di)
    alias(libs.plugins.project.serialization)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.foundation.abstraction)
            implementation(projects.shared.foundation.serialization)
            implementation(projects.shared.logger)
            api(projects.shared.core.network.api)
        }
        commonTest.dependencies {
            implementation(libs.ktor.client.mock)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.network.impl"
    }
}