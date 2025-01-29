package and.degilevich.dream.shared.foundation.decompose.navigator.stack

import kotlin.reflect.KClass

sealed interface StackNavigationAction<in StackConfig : Any> {
    class Pop<StackConfig : Any> : StackNavigationAction<StackConfig>

    data class Push<StackConfig : Any>(
        val config: StackConfig
    ) : StackNavigationAction<StackConfig>

    data class ReplaceCurrent<StackConfig : Any>(
        val config: StackConfig
    ) : StackNavigationAction<StackConfig>

    data class ReplaceAll<StackConfig : Any>(
        val configs: List<StackConfig>
    ) : StackNavigationAction<StackConfig> {
        constructor(
            vararg configs: StackConfig
        ) : this(configs.toList())
    }

    data class BringToFront<StackConfig : Any>(
        val config: StackConfig
    ) : StackNavigationAction<StackConfig>

    data class PushToFront<StackConfig : Any>(
        val config: StackConfig
    ) : StackNavigationAction<StackConfig>

    data class PushNew<StackConfig : Any>(
        val config: StackConfig
    ) : StackNavigationAction<StackConfig>

    data class PopUpTo<StackConfig : Any>(
        val configKClass: KClass<out StackConfig>
    ) : StackNavigationAction<StackConfig>

    data class PushOrReplace<StackConfig : Any>(
        val config: StackConfig,
        val replaceConfigKClass: KClass<out StackConfig>
    ) : StackNavigationAction<StackConfig>
}