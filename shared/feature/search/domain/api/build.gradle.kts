plugins {
    alias(libs.plugins.project.template.domain.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.model.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.domain.api"
}