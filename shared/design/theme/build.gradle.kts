plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.resource.api)
            api(projects.shared.foundation.compose)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.design.theme"
    }
}