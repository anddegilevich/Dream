plugins {
    alias(libs.plugins.project.template.design.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.track.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.design.api"
    }
}