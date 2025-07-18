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
            api(projects.shared.feature.album.component.releases.api)
            implementation(projects.shared.feature.album.domain.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.album.component.releases.impl"
}