plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.resource.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.resource.test"
    }
}
