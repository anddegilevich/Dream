plugins {
    alias(libs.plugins.project.template.source.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.category.model.core.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.category.source.api"
    }
}