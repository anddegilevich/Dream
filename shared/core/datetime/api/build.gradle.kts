plugins {
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.datetime)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.core.datetime.api"
    }
}