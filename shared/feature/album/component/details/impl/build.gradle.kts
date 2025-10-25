plugins {
    alias(libs.plugins.project.template.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.component.details.api)
            implementation(projects.shared.core.datetime.api)
            implementation(projects.shared.feature.album.domain.api)
            implementation(projects.shared.feature.artist.domain.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.album.component.details.impl"
}