plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.design.system)
        }

        androidMain.dependencies {
            implementation(libs.bundles.glance)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.app.api"
}