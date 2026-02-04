plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.serialization)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.multiplatform.settings)
            implementation(libs.multiplatform.settings.coroutines)
            implementation(libs.multiplatform.settings.datastore)
            implementation(projects.shared.foundation.primitive)
            implementation(projects.shared.foundation.serialization)
            implementation(projects.shared.core.crypto.api)
            implementation(libs.androidx.datastore.preferences)
            implementation(libs.androidx.datastore)
            api(projects.shared.core.storage.api)
        }
        commonTest.dependencies {
            implementation(libs.multiplatform.settings.test)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.core.storage.impl"
    }
}