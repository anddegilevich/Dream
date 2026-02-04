plugins {
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    androidLibrary {
        namespace = "and.degilevich.dream.shared.core.crypto.api"
    }
}