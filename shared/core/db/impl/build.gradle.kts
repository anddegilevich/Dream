plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.room)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.db.api)
            implementation(projects.shared.foundation.dispatcher)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.db.impl"
}