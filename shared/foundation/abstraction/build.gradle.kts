plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.primitive)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.foundation.abstraction"
    }
}