package and.degilevich.dream.convention.plugins

import and.degilevich.dream.convention.common.androidMainDependencies
import and.degilevich.dream.convention.common.commonMainDependencies
import and.degilevich.dream.convention.common.iosMainDependencies
import and.degilevich.dream.convention.common.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class KtorPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            commonMainDependencies {
                implementation(libs().ktor.client.core)
                implementation(libs().ktor.client.content.negotiation)
                implementation(libs().ktor.serialization.kotlinx.json)
                implementation(libs().ktor.client.logging)
            }

            androidMainDependencies {
                implementation(libs().ktor.client.okhttp)
            }

            iosMainDependencies {
                implementation(libs().ktor.client.darwin)
            }
        }
    }
}