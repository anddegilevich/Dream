plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
    alias(libs.plugins.project.koin)
    alias(libs.plugins.project.coroutines)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.decompose.extensions.compose)

            implementation(projects.shared.foundation.dispatcher)
            api(projects.shared.foundation.logger)

            implementation(projects.shared.core.client.impl)
            implementation(projects.shared.core.storage.impl)

            implementation(projects.shared.navigation.impl)

            implementation(projects.shared.feature.artist.core.impl)
            implementation(projects.shared.feature.artist.component.details.impl)
            implementation(projects.shared.feature.artist.component.list.impl)

            api(projects.shared.app.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.app.impl"
}