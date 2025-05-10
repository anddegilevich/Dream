plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.coroutine)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.template.source.api"
}