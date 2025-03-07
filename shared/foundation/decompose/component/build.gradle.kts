plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.bundles.decompose)
            api(libs.bundles.mvikotlin)
            api(projects.shared.foundation.primitive)
            api(projects.shared.foundation.serialization)
            api(projects.shared.foundation.abstraction)
            api(projects.shared.foundation.dispatcher)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.foundation.decompose.component"
}