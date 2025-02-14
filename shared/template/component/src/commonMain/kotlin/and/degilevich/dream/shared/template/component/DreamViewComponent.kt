package and.degilevich.dream.shared.template.component

import and.degilevich.dream.shared.foundation.decompose.component.view.AbstractViewComponent
import and.degilevich.dream.shared.foundation.decompose.component.view.ViewComponent
import and.degilevich.dream.shared.template.component.logger.LoggerExtendedLifecycleCallbacks
import com.arkivanov.decompose.ComponentContext
import kotlin.reflect.KClass

abstract class DreamViewComponent<out State : Any, in Intent, out SideEffect>(
    componentKClass: KClass<out ViewComponent<State, Intent, SideEffect>>,
    componentContext: ComponentContext
) : AbstractViewComponent<State, Intent, SideEffect>(componentContext = componentContext) {

    init {
        logLifecycleChanges(componentKClass)
    }

    private fun logLifecycleChanges(componentKClass: KClass<out ViewComponent<State, Intent, SideEffect>>) {
        lifecycle.subscribe(
            callbacks = LoggerExtendedLifecycleCallbacks(componentKClass = componentKClass)
        )
    }
}