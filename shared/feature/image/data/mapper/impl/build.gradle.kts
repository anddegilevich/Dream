plugins {
    alias(libs.plugins.project.template.data.mapper.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.image.data.mapper.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.image.data.mapper.impl"
    }
}
