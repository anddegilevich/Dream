plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
    alias(libs.plugins.project.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.template.component.impl)
            api(projects.shared.feature.common.component.navbar.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.common.component.navbar.impl"
}