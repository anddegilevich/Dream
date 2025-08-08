package and.degilevich.dream.convention.plugins

import and.degilevich.dream.convention.common.kotlinMultiplatformConfig
import and.degilevich.dream.convention.common.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class CoroutinesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            kotlinMultiplatformConfig {
                with(sourceSets) {
                    commonMain.dependencies {
                        implementation(libs().kotlinx.coroutines.core)
                    }
                    androidMain.dependencies {
                        implementation(libs().kotlinx.coroutines.android)
                    }
                    commonTest.dependencies {
                        implementation(libs().kotlinx.coroutines.test)
                    }
                }
            }
        }
    }
}