package and.degilevich.dream.convention.plugins

import and.degilevich.dream.convention.common.commonMainDependencies
import and.degilevich.dream.convention.common.commonTestDependencies
import and.degilevich.dream.convention.common.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class KoinPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            commonMainDependencies {
                implementation(project.dependencies.platform(libs().koin.bom))
                implementation(libs().koin.core)
            }

            commonTestDependencies {
                implementation(libs().koin.test)
            }
        }
    }
}