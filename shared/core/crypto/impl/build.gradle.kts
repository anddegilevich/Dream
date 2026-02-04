plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.foundation.primitive)
            api(projects.shared.core.crypto.api)
        }
    }
    androidLibrary {
        namespace = "and.degilevich.dream.shared.core.crypto.impl"
    }
}