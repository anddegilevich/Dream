plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
}

kotlin {
    sourceSets {
        androidMain.dependencies {

        }
        commonMain.dependencies {
            implementation(projects.shared.core.client.impl)

            implementation(projects.shared.navigation.impl)

            implementation(projects.shared.feature.artist.source.impl)
            implementation(projects.shared.feature.artist.component.details.impl)
            implementation(projects.shared.feature.artist.component.list.impl)
        }
        iosMain.dependencies {

        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.app"
}