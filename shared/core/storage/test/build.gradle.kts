plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.storage.api)
            implementation(projects.shared.foundation.abstraction)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.storage.test"
    }
}
