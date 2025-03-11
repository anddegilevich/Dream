plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.bundles.decompose)
            implementation(projects.shared.foundation.abstraction)
            implementation(projects.shared.foundation.serialization)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.foundation.decompose.navigator"
}