plugins {
    alias(libs.plugins.project.template.design.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.album.model.artifact.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.album.design.api"
    }
}