plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.decompose.navigator)
            api(projects.shared.foundation.abstraction)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.navigation.api"
}