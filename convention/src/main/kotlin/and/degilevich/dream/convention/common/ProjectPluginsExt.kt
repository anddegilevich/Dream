package and.degilevich.dream.convention.common

import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import org.gradle.api.provider.Provider
import org.gradle.plugin.use.PluginDependency

internal fun Project.plugins(block: PluginManager.() -> Unit) {
    pluginManager.apply(block)
}

internal fun PluginManager.apply(pluginProvider: Provider<PluginDependency>) {
    apply(pluginProvider.get().pluginId)
}