plugins {
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.di)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.logger)
            implementation(projects.shared.foundation.decompose)
            implementation(projects.shared.core.toast.api)
            implementation(projects.shared.navigation.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.base.component.impl"
    }
}