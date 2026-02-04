plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.decompose)
            api(projects.shared.foundation.abstraction)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.navigation.api"
    }
}