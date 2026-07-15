plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    android {
        namespace = "and.degilevich.dream.shared.feature.base.data.api"
    }
}