plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.foundation.serialization)
            api(projects.shared.foundation.dispatcher)
            implementation(projects.shared.core.storage.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.common.source.api"
}