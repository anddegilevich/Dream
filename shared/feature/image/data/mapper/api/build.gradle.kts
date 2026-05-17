plugins {
    alias(libs.plugins.project.template.data.mapper.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.image.domain.model.artifact)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.image.data.mapper.api"
    }
}
