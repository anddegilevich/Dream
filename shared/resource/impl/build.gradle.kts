plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.di)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.resource.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.resource.impl"
    }
}