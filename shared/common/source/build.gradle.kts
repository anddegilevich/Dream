plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.dispatcher)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.common.source"
}