plugins {
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.foundation.primitive)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.core.crypto.api"
    }
}