plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.auth.domain.api)
            api(projects.shared.feature.common.component.splash.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.common.component.splash.impl"
    }
}