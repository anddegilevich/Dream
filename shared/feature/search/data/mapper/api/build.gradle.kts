plugins {
    alias(libs.plugins.project.template.data.mapper.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.domain.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.data.mapper.api"
    }
}
