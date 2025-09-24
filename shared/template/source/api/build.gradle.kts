plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.service.api)
            api(projects.shared.core.db.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.template.source.api"
}