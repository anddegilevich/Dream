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
            api(projects.shared.feature.track.component.details.api)
            implementation(projects.shared.feature.track.domain.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.track.component.details.impl"
}