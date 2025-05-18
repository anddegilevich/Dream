package and.degilevich.dream.shared.template.component.impl

import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import and.degilevich.dream.shared.template.component.impl.logger.LoggerComponentLifecycleCallbacks
import com.arkivanov.decompose.ComponentContext
import kotlin.reflect.KClass

abstract class MVIComponentTemplate<out State : Any, in Intent, out SideEffect>(
    componentContext: ComponentContext
) : MVIComponent<State, Intent, SideEffect>, ComponentContext by componentContext {

    init {
        logLifecycleChanges(this::class)
    }

    private fun logLifecycleChanges(componentKClass: KClass<out MVIComponent<State, Intent, SideEffect>>) {
        lifecycle.subscribe(
            callbacks = LoggerComponentLifecycleCallbacks(componentKClass = componentKClass)
        )
    }
}