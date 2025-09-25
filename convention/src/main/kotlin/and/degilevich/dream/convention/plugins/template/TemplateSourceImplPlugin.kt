package and.degilevich.dream.convention.plugins.template

import and.degilevich.dream.convention.common.apply
import and.degilevich.dream.convention.common.kotlinMultiplatformConfig
import and.degilevich.dream.convention.common.libs
import and.degilevich.dream.convention.common.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class TemplateSourceImplPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins {
                apply(libs().plugins.android.library)
                apply(libs().plugins.project.multiplatform)
                apply(libs().plugins.project.serialization)
                apply(libs().plugins.project.koin)
            }
            kotlinMultiplatformConfig {
                with(sourceSets) {
                    commonMain.dependencies {
                        implementation(project(":shared:foundation:serialization"))
                        implementation(project(":shared:core:service:api"))
                        implementation(project(":shared:core:db:api"))
                        implementation(project(":shared:template:source:impl"))
                    }
                }
            }
        }
    }
}