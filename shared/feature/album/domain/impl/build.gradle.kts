plugins {
    alias(libs.plugins.project.template.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.album.source.api)
            api(projects.shared.feature.album.domain.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.album.domain.impl"
}