plugins {
    alias(libs.plugins.project.template.component.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.component.releases.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.common.component.dashboard.api"
}