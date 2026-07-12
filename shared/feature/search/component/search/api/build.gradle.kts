plugins {
    alias(libs.plugins.project.feature.component.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.component.search.api"
    }
}