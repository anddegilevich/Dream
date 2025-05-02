plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.decompose)
            api(projects.shared.logger)
            api(projects.shared.resource.api)
            api(projects.shared.core.toast.api)
            api(projects.shared.design.system)
            api(projects.shared.navigation.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.template.component"
}