plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.project.koin)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.template.source.impl)
            api(projects.shared.feature.image.source.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.image.source.impl"
}