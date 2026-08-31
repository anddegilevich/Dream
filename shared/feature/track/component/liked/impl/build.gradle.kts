plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.track.component.liked.api)
            implementation(projects.shared.feature.track.domain.api)
            implementation(projects.shared.feature.track.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.component.liked.impl"
    }
}
