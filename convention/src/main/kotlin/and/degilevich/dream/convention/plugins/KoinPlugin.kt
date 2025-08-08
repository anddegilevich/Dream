package and.degilevich.dream.convention.plugins

import and.degilevich.dream.convention.common.kotlinMultiplatformConfig
import and.degilevich.dream.convention.common.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class KoinPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            kotlinMultiplatformConfig {
                with(sourceSets) {
                    commonMain.dependencies {
                        implementation(project.dependencies.platform(libs().koin.bom))
                        implementation(libs().koin.core)
                        implementation(libs().koin.compose)
                    }
                    commonTest.dependencies {
                        implementation(libs().koin.test)
                    }
                    androidMain.dependencies {
                        implementation(libs().koin.android)
                        implementation(libs().koin.androidx.workmanager)
                    }
                }
            }
        }
    }
}