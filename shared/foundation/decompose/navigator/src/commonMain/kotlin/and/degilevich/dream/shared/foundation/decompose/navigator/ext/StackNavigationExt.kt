package and.degilevich.dream.shared.foundation.decompose.navigator.ext

import and.degilevich.dream.shared.foundation.decompose.navigator.stack.StackNavigationAction
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.StackNavigator
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.navigate
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popWhile
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.router.stack.replaceCurrent
import kotlin.reflect.KClass

@Suppress("SpreadOperator")
inline fun <reified StackConfig : Any> StackNavigation<in StackConfig>.executeNavigationAction(
    action: StackNavigationAction<StackConfig>
) {
    when (action) {
        is StackNavigationAction.Pop -> {
            pop()
        }

        is StackNavigationAction.BringToFront -> {
            bringToFront(action.config)
        }

        is StackNavigationAction.PopUpTo -> {
            popUpTo(action.configKClass)
        }

        is StackNavigationAction.Push -> {
            @OptIn(DelicateDecomposeApi::class)
            push(action.config)
        }

        is StackNavigationAction.PushNew -> {
            pushNew(action.config)
        }

        is StackNavigationAction.ReplaceAll -> {
            replaceAll(*action.configs.toTypedArray())
        }

        is StackNavigationAction.ReplaceCurrent -> {
            replaceCurrent(action.config)
        }

        is StackNavigationAction.PushToFront -> {
            pushToFront(
                configuration = action.config
            )
        }

        is StackNavigationAction.PushOrReplace -> {
            pushOrReplace(
                configuration = action.config,
                replaceConfigurationKClass = action.replaceConfigKClass
            )
        }
    }
}

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