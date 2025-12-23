plugins {
    alias(libs.plugins.project.template.domain.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.category.source.api)
            api(projects.shared.feature.category.domain.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.category.domain.impl"
}