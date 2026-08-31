plugins {
    alias(libs.plugins.project.feature.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.auth.data.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.auth.data.impl"
    }
}
