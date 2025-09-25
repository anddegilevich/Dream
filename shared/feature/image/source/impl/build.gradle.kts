plugins {
    alias(libs.plugins.project.template.source.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.image.source.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.image.source.impl"
}