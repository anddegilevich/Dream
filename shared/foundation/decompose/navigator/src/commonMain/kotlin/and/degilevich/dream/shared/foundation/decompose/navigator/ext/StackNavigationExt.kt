package and.degilevich.dream.shared.foundation.decompose.navigator.ext

import and.degilevich.dream.shared.foundation.decompose.navigator.stack.StackNavigationAction
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

fun <StackConfig : Any, StackConfigKClass> StackNavigator<StackConfig>.popUpTo(
    configurationKClass: StackConfigKClass
) where StackConfigKClass : KClass<StackConfig> {
    popWhile(
        predicate = { predicate ->
            !configurationKClass.isInstance(predicate)
        }
    )
}

fun <StackConfig : Any, StackConfigKClass> StackNavigator<StackConfig>.pushOrReplace(
    configuration: StackConfig,
    replaceConfigurationKClass: StackConfigKClass
) where StackConfigKClass : KClass<StackConfig> {
    navigate { stack ->
        if (replaceConfigurationKClass.isInstance(stack.last())) {
            stack.dropLast(1) + configuration
        } else {
            stack + configuration
        }
    }
}

@Suppress("SpreadOperator")
inline fun <reified StackConfig : Any, StackConfigKClass> StackNavigation<StackConfig>.executeNavigationAction(
    action: StackNavigationAction<StackConfig>
) where StackConfigKClass : KClass<StackConfig> {
    when (action) {
        is StackNavigationAction.Pop -> {
            pop()
        }

        is StackNavigationAction.BringToFront -> {
            bringToFront(action.config)
        }

        is StackNavigationAction.PopUpTo<*, *> -> {
            //FIXME: Check
            (action as? StackNavigationAction.PopUpTo<StackConfig, StackConfigKClass>)?.let {
                popUpTo(action.configKClass)
            }
        }

        is StackNavigationAction.Push -> {
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

        is StackNavigationAction.PushOrReplace<*, *> -> {
            //FIXME: Check
            (action as? StackNavigationAction.PushOrReplace<StackConfig, StackConfigKClass>)?.let {
                pushOrReplace(
                    configuration = action.config,
                    replaceConfigurationKClass = action.replaceConfigKClass
                )
            }
        }
    }
}