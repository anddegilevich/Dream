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
        libs.plugins.project.template.model.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.template.TemplateModelPlugin"
            }
        }
        libs.plugins.project.template.data.api.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.template.TemplateDataApiPlugin"
            }
        }
        libs.plugins.project.template.data.impl.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.template.TemplateDataImplPlugin"
            }
        }
        libs.plugins.project.template.data.mapper.api.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.template.TemplateDataMapperApiPlugin"
            }
        }
        libs.plugins.project.template.data.mapper.impl.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.template.TemplateDataMapperImplPlugin"
            }
        }
        libs.plugins.project.template.domain.api.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.template.TemplateDomainApiPlugin"
            }
        }
        libs.plugins.project.template.domain.impl.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.template.TemplateDomainImplPlugin"
            }
        }
        libs.plugins.project.template.ui.api.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.template.TemplateUIApiPlugin"
            }
        }
        libs.plugins.project.template.ui.impl.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.template.TemplateUIImplPlugin"
            }
        }
        libs.plugins.project.template.component.api.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.template.TemplateComponentApiPlugin"
            }
        }
        libs.plugins.project.template.component.impl.get().let { plugin ->
            register(plugin.pluginId) {
                id = plugin.pluginId
                implementationClass = "and.degilevich.dream.convention.plugins.template.TemplateComponentImplPlugin"
            }
        }
    }
}

group = "and.degilevich.dream.convention"