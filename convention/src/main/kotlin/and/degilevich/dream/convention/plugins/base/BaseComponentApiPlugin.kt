package and.degilevich.dream.convention.plugins.base

import and.degilevich.dream.convention.common.apply
import and.degilevich.dream.convention.common.kotlinMultiplatformConfig
import and.degilevich.dream.convention.common.libs
import and.degilevich.dream.convention.common.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class BaseComponentApiPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins {
                apply(libs().plugins.kmp.library)
                apply(libs().plugins.project.multiplatform)
                apply(libs().plugins.compose.compiler)
            }
            kotlinMultiplatformConfig {
                with(sourceSets) {
                    commonMain.dependencies {
                        implementation(project(":shared:foundation:decompose"))
                        implementation(libs().compose.runtime)
                    }
                }
            }
        }
    }
}