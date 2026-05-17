plugins {
    alias(libs.plugins.project.template.data.mapper.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.domain.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.data.mapper.api"
    }
}
