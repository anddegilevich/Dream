plugins {
    alias(libs.plugins.project.template.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.track.data.api)
            api(projects.shared.feature.track.domain.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.track.domain.impl"
    }
}