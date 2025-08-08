package and.degilevich.dream.convention.plugins

import and.degilevich.dream.convention.common.kotlinMultiplatformConfig
import and.degilevich.dream.convention.common.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class KtorPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            kotlinMultiplatformConfig {
                with(sourceSets) {
                    commonMain.dependencies {
                        implementation(libs().ktor.client.core)
                        implementation(libs().ktor.client.content.negotiation)
                        implementation(libs().ktor.serialization.kotlinx.json)
                        implementation(libs().ktor.client.logging)
                        implementation(libs().ktor.client.auth)
                    }
                    androidMain.dependencies {
                        implementation(libs().ktor.client.okhttp)
                    }
                    iosMain.dependencies {
                        implementation(libs().ktor.client.darwin)
                    }
                }
            }
        }
    }
}