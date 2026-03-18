plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    android {
        namespace = "and.degilevich.dream.shared.core.service.api"
    }
}