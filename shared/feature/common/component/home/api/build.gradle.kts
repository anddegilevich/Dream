plugins {
    alias(libs.plugins.project.template.component.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.common.component.dashboard.api)
            api(projects.shared.feature.common.component.navbar.api)
            api(projects.shared.feature.search.component.search.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.common.component.home.api"
}