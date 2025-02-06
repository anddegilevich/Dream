plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.ktor)
}

android {
    namespace = "and.degilevich.dream.shared.core.client.api"
}