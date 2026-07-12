plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.search.domain.api)
            implementation(projects.shared.feature.search.ui.api)
            api(projects.shared.feature.search.component.search.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.component.search.impl"
    }
}