plugins {
    alias(libs.plugins.project.template.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.album.component.releases.api)
            implementation(projects.shared.feature.album.domain.api)
        }
    }

    androidLibrary {
        namespace = "and.degilevich.dream.shared.feature.album.component.releases.impl"
    }
}