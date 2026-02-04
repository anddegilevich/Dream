plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.abstraction)
            api(projects.shared.resource.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.core.toast.api"
    }
}