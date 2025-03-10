package and.degilevich.dream.shared.foundation.decompose.navigator.stack

import kotlin.reflect.KClass

@Suppress("TooManyFunctions")
interface StackNavigator<StackConfig : Any> {
    fun navigate(action: StackNavigationAction<StackConfig>)
    fun pop()
    fun push(config: StackConfig)
    fun replaceCurrent(config: StackConfig)
    fun replaceAll(configs: List<StackConfig>)
    fun replaceAll(vararg configs: StackConfig)
    fun bringToFront(config: StackConfig)
    fun pushToFront(config: StackConfig)
    fun pushNew(config: StackConfig)
    fun popUpTo(configKClass: KClass<out StackConfig>)
    fun pushOrReplace(
        config: StackConfig,
        replaceConfigKClass: KClass<out StackConfig>
    )
}