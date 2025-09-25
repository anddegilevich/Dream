plugins {
    alias(libs.plugins.project.template.domain.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.model.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.domain.api"
}