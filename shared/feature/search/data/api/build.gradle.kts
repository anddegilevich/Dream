plugins {
    alias(libs.plugins.project.feature.data.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.domain.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.data.api"
    }
}