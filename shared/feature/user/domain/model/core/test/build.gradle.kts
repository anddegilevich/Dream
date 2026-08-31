plugins {
    alias(libs.plugins.project.feature.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.user.domain.model.core.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.user.model.core.test"
    }
}
