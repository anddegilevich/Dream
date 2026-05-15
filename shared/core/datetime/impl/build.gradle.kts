plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.di)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.datetime.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.datetime.impl"
    }
}