plugins {
    alias(libs.plugins.project.template.source.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.image.source.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.image.source.impl"
    }
}