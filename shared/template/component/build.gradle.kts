plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.decompose.component)
            api(projects.shared.logger)
            api(projects.shared.resource.api)
            api(projects.shared.core.toast.api)
            api(projects.shared.design.system)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.template.component"
}