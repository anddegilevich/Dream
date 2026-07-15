plugins {
    alias(libs.plugins.project.feature.component.api)
    alias(libs.plugins.project.serialization)
}

kotlin {
    android {
        namespace = "and.degilevich.dream.shared.feature.common.component.navbar.api"
    }
}