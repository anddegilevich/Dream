import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.compose)
    alias(libs.plugins.project.koin)
    alias(libs.plugins.project.coroutines)
    alias(libs.plugins.moko.multiplatfrom.resources)
}

kotlin {
    iosArm64()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        NativeBuildType.DEFAULT_BUILD_TYPES.forEach { buildType ->
            iosTarget.binaries.getFramework(buildType = buildType).apply {
                export(libs.bundles.decompose)
                export(libs.moko.resources)
                export(projects.shared.app.api)
                export(projects.shared.di)
                export(projects.shared.logger)
                export(projects.shared.widget.impl)
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            // Libs
            implementation(libs.decompose.extensions.compose)

            // Logger
            api(projects.shared.logger)

            // Core
            implementation(projects.shared.core.filepicker.api)
            implementation(projects.shared.core.toast.api)

            // Navigation
            implementation(projects.shared.navigation.impl)

            // DI
            api(projects.shared.di)

            // Feature
            implementation(projects.shared.feature.common.component.splash.impl)
            implementation(projects.shared.feature.common.component.dashboard.impl)

            implementation(projects.shared.feature.artist.component.details.impl)
            implementation(projects.shared.feature.artist.component.list.impl)

            implementation(projects.shared.feature.album.component.details.impl)

            implementation(projects.shared.feature.user.component.profile.impl)

            // Widget
            api(projects.shared.widget.impl)

            api(projects.shared.app.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.app.impl"
}