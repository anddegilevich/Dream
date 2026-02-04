plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.datetime.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.core.datetime.impl"
    }
}