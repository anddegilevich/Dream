package and.degilevich.dream.convention.plugins

import and.degilevich.dream.convention.common.apply
import and.degilevich.dream.convention.common.kotlinMultiplatformConfig
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
                apply(libs().plugins.compose.stability.analyzer)
                apply(libs().plugins.moko.multiplatfrom.resources)
            }
            kotlinMultiplatformConfig {
                with (sourceSets) {
                    commonMain.dependencies {
                        implementation(libs().compose.runtime)
                        implementation(libs().compose.material)
                        implementation(libs().compose.ui)
                        implementation(libs().compose.ui.backhandler)
                        implementation(libs().compose.ui.tooling.preview)
                        implementation(libs().moko.resources)
                        implementation(libs().moko.resources.compose)
                    }
                    androidMain.dependencies {
                        runtimeOnly(libs().compose.ui.tooling)
                        implementation(libs().androidx.lifecycle.runtime.compose)
                        implementation(libs().androidx.activity.compose)
                    }
                    commonTest.dependencies {
                        implementation(libs().compose.ui.test)
                        implementation(libs().moko.resources.test)
                    }
                    getByName("androidDeviceTest") {
                        dependencies {
                            implementation(libs().compose.ui.test.junit4.android)
                            runtimeOnly(libs().compose.ui.test.manifest)
                        }
                    }
                }
            }
        }
    }
}