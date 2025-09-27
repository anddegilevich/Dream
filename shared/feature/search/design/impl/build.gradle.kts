plugins {
    alias(libs.plugins.project.template.design.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.search.design.api)
            implementation(projects.shared.feature.search.model.core.api)
            implementation(projects.shared.feature.artist.design.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.design.impl"
}