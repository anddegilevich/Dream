plugins {
    alias(libs.plugins.project.template.design.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.artist.model.core.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.artist.design.api"
    }
}