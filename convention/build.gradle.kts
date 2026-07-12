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
    implementation(libs.compose.gradle)
    implementation(libs.compose.compiler.gradle)
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
        libs.plugins.project.di.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.DIPlugin"
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
        libs.plugins.project.feature.model.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.base.BaseModelPlugin"
            }
        }
        libs.plugins.project.feature.data.api.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.base.BaseDataApiPlugin"
            }
        }
        libs.plugins.project.feature.data.impl.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.base.BaseDataImplPlugin"
            }
        }
        libs.plugins.project.feature.data.mapper.api.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.base.BaseDataMapperApiPlugin"
            }
        }
        libs.plugins.project.feature.data.mapper.impl.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.base.BaseDataMapperImplPlugin"
            }
        }
        libs.plugins.project.feature.domain.api.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.base.BaseDomainApiPlugin"
            }
        }
        libs.plugins.project.feature.domain.impl.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.base.BaseDomainImplPlugin"
            }
        }
        libs.plugins.project.feature.ui.api.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.base.BaseUIApiPlugin"
            }
        }
        libs.plugins.project.feature.ui.impl.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.base.BaseUIImplPlugin"
            }
        }
        libs.plugins.project.feature.component.api.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.base.BaseComponentApiPlugin"
            }
        }
        libs.plugins.project.feature.component.impl.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.base.BaseComponentImplPlugin"
            }
        }
    }
}

group = "and.degilevich.dream.convention"