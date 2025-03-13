plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.decompose.extensions.compose)

            implementation(projects.shared.foundation.decompose.compose)
            implementation(projects.shared.core.toast.api)
            implementation(projects.shared.core.filepicker.api)

            api(projects.shared.navigation.api)

            api(projects.shared.template.component)

            api(projects.shared.feature.artist.component.details.api)
            api(projects.shared.feature.artist.component.list.api)

            api(projects.shared.feature.user.component.profile.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.app.api"
}