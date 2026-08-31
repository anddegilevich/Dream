plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.playlist.component.list.api)
            implementation(projects.shared.feature.playlist.domain.api)
            implementation(projects.shared.feature.playlist.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.playlist.component.list.impl"
    }
}
