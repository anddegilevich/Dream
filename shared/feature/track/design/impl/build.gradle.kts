plugins {
    alias(libs.plugins.project.template.design.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.design.api)
            implementation(projects.shared.feature.track.model.core.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.track.design.impl"
    }
}