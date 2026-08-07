plugins {
    alias(libs.plugins.project.feature.data.mapper.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.data.mapper.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.data.mapper.test"
    }
}
