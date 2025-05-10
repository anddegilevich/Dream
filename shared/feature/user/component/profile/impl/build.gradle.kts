plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.koin)
    alias(libs.plugins.project.serialization)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.template.component.impl)
            api(projects.shared.feature.user.component.profile.api)
            implementation(projects.shared.core.filepicker.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.user.component.profile.impl"
}