plugins {
    alias(libs.plugins.project.template.design.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.artist.design.api)
            implementation(projects.shared.feature.artist.model.core.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.artist.design.impl"
    }
}