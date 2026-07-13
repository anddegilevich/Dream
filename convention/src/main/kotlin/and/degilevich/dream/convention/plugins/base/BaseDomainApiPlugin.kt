package and.degilevich.dream.convention.plugins.base

import and.degilevich.dream.convention.common.apply
import and.degilevich.dream.convention.common.libs
import and.degilevich.dream.convention.common.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class BaseDomainApiPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins {
                apply(libs().plugins.kmp.library)
                apply(libs().plugins.project.multiplatform)
            }
        }
    }
}