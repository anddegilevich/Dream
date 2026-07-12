plugins {
    alias(libs.plugins.project.feature.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.domain.model.artifact)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.model.core"
    }
}