plugins {
    alias(libs.plugins.project.template.data.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.data.api)
            implementation(projects.shared.feature.search.data.mapper.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.data.impl"
    }
}