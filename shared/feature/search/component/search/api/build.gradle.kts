plugins {
    alias(libs.plugins.project.template.component.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.design.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.component.search.api"
}