plugins {
    alias(libs.plugins.project.template.component.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.design.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.album.component.releases.api"
    }
}