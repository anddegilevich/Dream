package and.degilevich.dream.convention.plugins

import and.degilevich.dream.convention.common.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class ComposePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins {
                apply("compose-convention")
            }
        }
    }
}