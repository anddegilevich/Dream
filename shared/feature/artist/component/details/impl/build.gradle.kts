plugins {
    alias(libs.plugins.project.template.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.artist.domain.api)
            api(projects.shared.feature.artist.component.details.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.artist.component.details.impl"
}