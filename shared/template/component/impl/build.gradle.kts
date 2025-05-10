plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.logger)
            api(projects.shared.core.toast.api)
            api(projects.shared.navigation.api)
            api(projects.shared.template.component.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.template.component.impl"
}