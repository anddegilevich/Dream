package and.degilevich.dream.convention.plugins

import and.degilevich.dream.convention.common.androidMainDependencies
import and.degilevich.dream.convention.common.commonMainDependencies
import and.degilevich.dream.convention.common.commonTestDependencies
import and.degilevich.dream.convention.common.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class CoroutinesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            commonMainDependencies {
                implementation(libs().kotlinx.coroutines.core)
            }

            androidMainDependencies {
                implementation(libs().kotlinx.coroutines.android)
            }

            commonTestDependencies {
                implementation(libs().kotlinx.coroutines.test)
            }
        }
    }
}