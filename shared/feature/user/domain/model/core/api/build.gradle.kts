plugins {
    alias(libs.plugins.project.feature.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.user.domain.model.artifact.api)
            api(projects.shared.feature.image.domain.model.artifact.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.user.model.core.api"
    }
}
