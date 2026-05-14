plugins {
    alias(libs.plugins.project.template.model)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.model.artifact)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.album.model.core"
    }
}