package and.degilevich.dream.convention.plugins.template

import and.degilevich.dream.convention.common.apply
import and.degilevich.dream.convention.common.kotlinMultiplatformConfig
import and.degilevich.dream.convention.common.libs
import and.degilevich.dream.convention.common.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class TemplateModelApiPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins {
                apply(libs().plugins.android.library)
                apply(libs().plugins.project.multiplatform)
                apply(libs().plugins.project.serialization)
            }
            kotlinMultiplatformConfig {
                with(sourceSets) {
                    commonMain.dependencies {
                        api(project(":shared:foundation:abstraction"))
                    }
                }
            }
        }
    }
}