package and.degilevich.dream.convention.plugins

import and.degilevich.dream.convention.common.androidMainDependencies
import and.degilevich.dream.convention.common.apply
import and.degilevich.dream.convention.common.commonMainDependencies
import and.degilevich.dream.convention.common.libs
import and.degilevich.dream.convention.common.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class ComposePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins {
                apply(libs().plugins.compose.compiler)
                apply(libs().plugins.compose.multiplatform)
            }
            commonMainDependencies {
                implementation(libs().compose.runtime)
                implementation(libs().compose.material)
                implementation(libs().compose.ui)
                implementation(libs().compose.ui.backhandler)
            }
            androidMainDependencies {
                implementation(libs().compose.ui.tooling)
                implementation(libs().androidx.lifecycle.runtime.compose)
                implementation(libs().androidx.activity.compose)
            }
        }
    }
}