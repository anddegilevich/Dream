plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(compose.components.resources)
        }
    }
}

compose {
    resources {
        publicResClass = true
        packageOfResClass = "and.degilevich.dream.shared.resource.api"
        generateResClass = auto
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.resource.api"
}