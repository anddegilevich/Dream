plugins {
    alias(libs.plugins.project.template.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.category.component.list.api)
            implementation(projects.shared.feature.category.domain.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.category.component.list.impl"
}