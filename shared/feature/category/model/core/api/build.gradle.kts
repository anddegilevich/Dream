plugins {
    alias(libs.plugins.project.template.model.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.image.model.artifact.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.category.model.core.api"
    }
}