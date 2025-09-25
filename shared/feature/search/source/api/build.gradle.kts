plugins {
    alias(libs.plugins.project.template.source.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.model.core.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.source.api"
}