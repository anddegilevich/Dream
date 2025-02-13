plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.decompose.component)
            api(projects.shared.core.logger)
            api(projects.shared.core.resource.api)
            api(projects.shared.core.toast.api)
            api(projects.shared.compose.design)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.template.component"
}