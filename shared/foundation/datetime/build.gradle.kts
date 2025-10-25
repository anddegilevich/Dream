plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.datetime)
            implementation(projects.shared.foundation.primitive)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.foundation.datetime"
}