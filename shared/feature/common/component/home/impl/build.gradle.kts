plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.common.component.dashboard.api)
            implementation(projects.shared.feature.common.component.navbar.api)
            implementation(projects.shared.feature.search.component.search.api)
            api(projects.shared.feature.common.component.home.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.common.component.home.impl"
    }
}