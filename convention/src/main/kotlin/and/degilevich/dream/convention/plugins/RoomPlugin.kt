package and.degilevich.dream.convention.plugins

import and.degilevich.dream.convention.common.androidMainDependencies
import and.degilevich.dream.convention.common.apply
import and.degilevich.dream.convention.common.commonMainDependencies
import and.degilevich.dream.convention.common.commonTestDependencies
import and.degilevich.dream.convention.common.libs
import and.degilevich.dream.convention.common.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class RoomPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins {
                apply(libs().plugins.ksp)
            }

            commonMainDependencies {
                implementation(libs().room.runtime)
                implementation(libs().room.paging)
                implementation(libs().sqlite)
                implementation(libs().sqlite.bundled)
            }

            commonTestDependencies {
                implementation(libs().room.testing)
            }

            androidMainDependencies {
                implementation(libs().room.ktx)
            }

            dependencies {
                add("kspAndroid", libs().room.compiler)
                add("kspIosSimulatorArm64", libs().room.compiler)
                add("kspIosX64", libs().room.compiler)
                add("kspIosArm64", libs().room.compiler)
            }
        }
    }
}