plugins {
    alias(libs.plugins.project.template.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.album.component.releases.impl)
            implementation(projects.shared.feature.category.component.list.impl)
            api(projects.shared.feature.common.component.dashboard.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.common.component.dashboard.impl"
}