package and.degilevich.dream.convention.plugins

import and.degilevich.dream.convention.common.apply
import and.degilevich.dream.convention.common.commonMainDependencies
import and.degilevich.dream.convention.common.libs
import and.degilevich.dream.convention.common.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class SerializationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins {
                apply(libs().plugins.kotlinx.serialization)
            }

            commonMainDependencies {
                implementation(libs().kotlinx.serialization.json)
            }
        }
    }
}