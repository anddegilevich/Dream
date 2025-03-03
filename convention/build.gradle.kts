plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.kotlin.gradle)
    implementation(libs.android.gradle)
    implementation(libs.detekt.gradle)
    implementation(libs.compose.multiplatform.gradle)
    implementation(libs.compose.compiler.gradle)
    // Required for accessing version catalog for conventions/plugins
    // Issue - https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        version = libs.versions.project.plugin

        libs.plugins.project.android.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.AndroidPlugin"
            }
        }
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
        libs.plugins.project.room.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.RoomPlugin"
            }
        }
    }
}

group = "and.degilevich.dream.convention"