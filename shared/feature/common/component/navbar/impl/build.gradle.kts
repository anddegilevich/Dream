plugins {
    alias(libs.plugins.project.template.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.common.component.navbar.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.common.component.navbar.impl"
    }
}