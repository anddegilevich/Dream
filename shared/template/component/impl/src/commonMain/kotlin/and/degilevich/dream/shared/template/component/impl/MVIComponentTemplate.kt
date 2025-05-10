package and.degilevich.dream.shared.template.component.impl

import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponentAbs
import and.degilevich.dream.shared.template.component.impl.logger.LoggerComponentLifecycleCallbacks
import com.arkivanov.decompose.ComponentContext
import kotlin.reflect.KClass

abstract class MVIComponentTemplate<out State : Any, in Intent, out SideEffect>(
    componentContext: ComponentContext
) : MVIComponentAbs<State, Intent, SideEffect>(componentContext = componentContext) {

    init {
        logLifecycleChanges(this::class)
    }

    private fun logLifecycleChanges(componentKClass: KClass<out MVIComponent<State, Intent, SideEffect>>) {
        lifecycle.subscribe(
            callbacks = LoggerComponentLifecycleCallbacks(componentKClass = componentKClass)
        )
    }
}