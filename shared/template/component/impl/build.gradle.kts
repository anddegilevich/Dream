plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.logger)
            implementation(projects.shared.foundation.decompose)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.template.component.impl"
}