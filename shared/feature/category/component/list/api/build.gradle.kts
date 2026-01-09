plugins {
    alias(libs.plugins.project.template.component.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.design.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.category.component.list.api"
}