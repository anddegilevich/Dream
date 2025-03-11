package and.degilevich.dream.shared.foundation.decompose.navigation.ext

import com.arkivanov.decompose.router.stack.StackNavigator
import com.arkivanov.decompose.router.stack.navigate
import com.arkivanov.decompose.router.stack.popWhile
import kotlin.reflect.KClass

fun <StackConfig : Any, T> StackNavigator<StackConfig>.popUpTo(
    configurationKClass: KClass<out StackConfig>
) where T : StackConfig {
    popWhile(
        predicate = { predicate ->
            !configurationKClass.isInstance(predicate)
        }
    )
}

fun <StackConfig : Any> StackNavigator<StackConfig>.pushOrReplace(
    configuration: StackConfig,
    replaceConfigurationKClass: KClass<out StackConfig>
) {
    navigate { stack ->
        if (replaceConfigurationKClass.isInstance(stack.last())) {
            stack.dropLast(1) + configuration
        } else {
            stack + configuration
        }
    }
}

fun <StackConfig : Any> StackNavigator<StackConfig>.replaceAll(configs: List<StackConfig>) {
    navigate(
        transformer = { configs }
    )
}
