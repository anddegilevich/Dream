plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.common.component.drawer.api)
            implementation(projects.shared.feature.auth.domain.api)
            implementation(projects.shared.feature.user.domain.api)
            implementation(projects.shared.feature.user.ui.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.feature.common.component.drawer.impl"
    }
}
