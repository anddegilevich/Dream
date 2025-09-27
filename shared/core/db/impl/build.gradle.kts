import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType
import kotlin.apply

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.project.multiplatform)
    alias(libs.plugins.project.room)
    alias(libs.plugins.project.koin)
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        NativeBuildType.DEFAULT_BUILD_TYPES.forEach { buildType ->
            iosTarget.binaries.getFramework(buildType = buildType).apply {
                linkerOpts.add("-lsqlite3")
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(projects.shared.core.db.api)
        }
    }
}

android {
    namespace = "and.degilevich.dream.shared.core.db.impl"
}