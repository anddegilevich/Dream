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
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.template.component"
}