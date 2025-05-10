plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.foundation.decompose)
            api(projects.shared.design.system)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.template.component.api"
}