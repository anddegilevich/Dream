plugins {
    alias(libs.plugins.project.template.data.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.image.model.artifact)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.image.data.api"
    }
}