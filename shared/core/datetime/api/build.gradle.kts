plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.datetime)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.datetime.api"
}