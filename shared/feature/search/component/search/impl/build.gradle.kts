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
            implementation(projects.shared.feature.search.domain.api)
            api(projects.shared.feature.search.component.search.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.component.search.impl"
}