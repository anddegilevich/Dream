plugins {
    alias(libs.plugins.project.template.ui.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.ui.api)
            implementation(projects.shared.feature.search.domain.model.core)
            implementation(projects.shared.feature.artist.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.search.ui.impl"
    }
}