plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.template.source.api)
            api(projects.shared.feature.search.model.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.source.api"
}