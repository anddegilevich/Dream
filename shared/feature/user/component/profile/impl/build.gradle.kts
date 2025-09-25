plugins {
    alias(libs.plugins.project.template.component.impl)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.user.component.profile.api)
            implementation(projects.shared.core.filepicker.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.feature.user.component.profile.impl"
}