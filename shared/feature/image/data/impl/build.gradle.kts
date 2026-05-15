plugins {
    alias(libs.plugins.project.template.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.image.data.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.image.data.impl"
    }
}