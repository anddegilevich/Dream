plugins {
    alias(libs.plugins.project.template.model.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.image.model.artifact.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.category.model.core.api"
}