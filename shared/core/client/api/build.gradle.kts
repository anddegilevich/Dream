plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.ktor)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.primitive)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.core.client.api"
    }
}