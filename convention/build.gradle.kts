plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    api(libs.kotlin.gradle)
    api(libs.android.gradle)
    api(libs.detekt.gradle)
    api(libs.compose.multiplatform.gradle)
    api(libs.compose.compiler.gradle)
    // Required for accessing version catalog for conventions/plugins
    // Issue - https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        version = libs.versions.project.plugin

        libs.plugins.project.multiplatform.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.MultiplatformPlugin"
            }
        }
        libs.plugins.project.compose.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.ComposePlugin"
            }
        }
        libs.plugins.project.serialization.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.SerializationPlugin"
            }
        }
        libs.plugins.project.coroutines.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.CoroutinesPlugin"
            }
        }
        libs.plugins.project.koin.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.KoinPlugin"
            }
        }
        libs.plugins.project.ktor.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.KtorPlugin"
            }
        }
    }
}

group = "and.degilevich.dream.convention"