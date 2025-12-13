plugins {
    alias(libs.plugins.project.template.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.common.component.dashboard.impl)
            implementation(projects.shared.feature.common.component.navbar.impl)
            implementation(projects.shared.feature.search.component.search.impl)
            api(projects.shared.feature.common.component.home.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.common.component.home.impl"
}