plugins {
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.datetime)
            implementation(projects.shared.foundation.primitive)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.foundation.datetime"
    }
}