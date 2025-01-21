plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.bundles.decompose)
            api(libs.bundles.mvikotlin)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.common.component"
}