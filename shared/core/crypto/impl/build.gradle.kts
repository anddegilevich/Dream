plugins {
    alias(libs.plugins.android.library)
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
}

android {
    namespace = "and.degilevich.dream.shared.core.crypto.impl"
}