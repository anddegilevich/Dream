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
                export(projects.shared.core.logger)
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.decompose.extensions.compose)

            implementation(projects.shared.foundation.dispatcher)

            api(projects.shared.core.logger)
            implementation(projects.shared.core.resource.impl)
            implementation(projects.shared.core.storage.impl)
            implementation(projects.shared.core.client.impl)
            implementation(projects.shared.core.service.impl)
            implementation(projects.shared.core.toast.impl)
            implementation(projects.shared.core.db.impl)

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