plugins {
    alias(libs.plugins.project.template.domain.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.model.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.album.domain.api"
}