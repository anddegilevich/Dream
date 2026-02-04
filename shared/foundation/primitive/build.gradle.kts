plugins {
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.collections.immutable)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.foundation.primitive"
    }
}