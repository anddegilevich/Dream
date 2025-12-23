plugins {
    alias(libs.plugins.project.template.source.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.image.source.api)
            api(projects.shared.feature.category.source.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.category.source.impl"
}