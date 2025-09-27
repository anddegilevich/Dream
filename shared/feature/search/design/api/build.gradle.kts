plugins {
    alias(libs.plugins.project.template.design.api)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.search.model.core.api)
            implementation(projects.shared.feature.artist.design.api)
            implementation(projects.shared.feature.album.design.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.design.api"
}