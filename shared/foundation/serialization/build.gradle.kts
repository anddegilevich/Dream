plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    jvm()
}

android {
    namespace = "and.degilevich.dream.shared.foundation.serialization"
}