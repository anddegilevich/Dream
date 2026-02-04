plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    androidLibrary {
        namespace = "and.degilevich.dream.shared.foundation.serialization"
    }
}