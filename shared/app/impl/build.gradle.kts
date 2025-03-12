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
                export(projects.shared.logger)
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            // Libs
            implementation(libs.decompose.extensions.compose)

            // Foundation
            implementation(projects.shared.foundation.dispatcher)

            // Core
            api(projects.shared.logger)
            implementation(projects.shared.resource.impl)
            implementation(projects.shared.core.storage.impl)
            implementation(projects.shared.core.client.impl)
            implementation(projects.shared.core.service.impl)
            implementation(projects.shared.core.toast.impl)
            implementation(projects.shared.core.db.impl)

            // Navigation
            implementation(projects.shared.navigation.impl)

            // Feature
            implementation(projects.shared.feature.artist.core.impl)
            implementation(projects.shared.feature.artist.design.impl)
            implementation(projects.shared.feature.artist.component.details.impl)
            implementation(projects.shared.feature.artist.component.list.impl)

            implementation(projects.shared.feature.user.component.profile.impl)

            api(projects.shared.app.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.app.impl"
}