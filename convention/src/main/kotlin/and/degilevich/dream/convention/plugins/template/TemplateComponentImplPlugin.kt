package and.degilevich.dream.convention.plugins.template

import and.degilevich.dream.convention.common.apply
import and.degilevich.dream.convention.common.kotlinMultiplatformConfig
import and.degilevich.dream.convention.common.libs
import and.degilevich.dream.convention.common.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class TemplateComponentImplPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins {
                apply(libs().plugins.android.library)
                apply(libs().plugins.project.multiplatform)
                apply(libs().plugins.project.koin)
                apply(libs().plugins.project.serialization)
                apply(libs().plugins.project.coroutines)
            }
            kotlinMultiplatformConfig {
                with(sourceSets) {
                    commonMain.dependencies {
                        implementation(project(":shared:template:component:impl"))
                        implementation(project(":shared:logger"))
                        implementation(project(":shared:core:toast:api"))
                        implementation(project(":shared:navigation:api"))
                    }
                }
            }
        }
    }
}