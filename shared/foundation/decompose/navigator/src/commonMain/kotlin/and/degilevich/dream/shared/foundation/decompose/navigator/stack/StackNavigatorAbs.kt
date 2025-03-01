package and.degilevich.dream.shared.foundation.decompose.navigator.stack

import kotlin.reflect.KClass

abstract class StackNavigatorAbs<StackConfig : Any>(
    private val navigationActionHandler: StackNavigationActionHandler<StackConfig>
) : StackNavigator<StackConfig> {

    override fun navigate(action: StackNavigationAction<StackConfig>) {
        navigationActionHandler.handle(action)
    }

    override fun pop() {
        navigate(StackNavigationAction.Pop())
    }

    override fun push(config: StackConfig) {
        navigate(
            StackNavigationAction.Push(config)
        )
    }

    override fun replaceCurrent(config: StackConfig) {
        navigate(
            StackNavigationAction.ReplaceCurrent(config)
        )
    }

    override fun replaceAll(configs: List<StackConfig>) {
        navigate(
            StackNavigationAction.ReplaceAll(configs)
        )
    }

    override fun replaceAll(vararg configs: StackConfig) {
        replaceAll(configs.toList())
    }

    override fun bringToFront(config: StackConfig) {
        navigate(
            StackNavigationAction.BringToFront(config)
        )
    }

    override fun pushToFront(config: StackConfig) {
        navigate(
            StackNavigationAction.PushToFront(config)
        )
    }

    override fun pushNew(config: StackConfig) {
        navigate(
            StackNavigationAction.PushNew(config)
        )
    }

    override fun popUpTo(configKClass: KClass<out StackConfig>) {
        navigate(
            StackNavigationAction.PopUpTo(configKClass)
        )
    }

    override fun pushOrReplace(config: StackConfig, replaceConfigKClass: KClass<out StackConfig>) {
        navigate(
            StackNavigationAction.PushOrReplace(
                config = config,
                replaceConfigKClass = replaceConfigKClass
            )
        )
    }
}