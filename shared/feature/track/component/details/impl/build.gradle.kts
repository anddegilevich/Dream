plugins {
    alias(libs.plugins.project.template.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.track.domain.api)
            api(projects.shared.feature.track.component.details.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.track.component.details.impl"
}