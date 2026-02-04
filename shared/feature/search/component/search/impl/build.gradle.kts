plugins {
    alias(libs.plugins.project.template.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.search.domain.api)
            api(projects.shared.feature.search.component.search.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.search.component.search.impl"
    }
}