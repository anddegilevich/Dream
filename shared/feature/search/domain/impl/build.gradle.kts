plugins {
    alias(libs.plugins.project.template.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.search.source.api)
            api(projects.shared.feature.search.domain.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.search.domain.impl"
}