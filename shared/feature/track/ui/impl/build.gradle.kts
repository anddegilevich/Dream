plugins {
    alias(libs.plugins.project.template.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.ui.api)
            implementation(projects.shared.feature.track.model.core)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.ui.impl"
    }
}