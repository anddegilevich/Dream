import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
    alias(libs.plugins.project.feature.component.impl)
}

kotlin {
    listOf(
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
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            // Libs
            implementation(libs.decompose.extensions.compose)
            api(libs.bundles.decompose)
            api(libs.moko.resources)

            // Logger
            api(projects.shared.logger)

            api(projects.shared.foundation.decompose)
            api(projects.shared.feature.base.component.impl)

            // Navigation
            implementation(projects.shared.navigation.impl)

            // DI
            api(projects.shared.di)

            // Feature
            implementation(projects.shared.feature.common.component.splash.impl)
            implementation(projects.shared.feature.common.component.home.impl)

            implementation(projects.shared.feature.artist.component.details.impl)

            implementation(projects.shared.feature.album.component.details.impl)

            implementation(projects.shared.feature.track.component.details.impl)

            api(projects.shared.app.api)
        }
    }

    android {
        namespace = "and.degilevich.dream.shared.app.impl"
    }
}
