package and.degilevich.dream.shared.foundation.decompose.component.view

import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponentAbs
import and.degilevich.dream.shared.foundation.decompose.lifecycle.ComponentExtendedLifecycle
import and.degilevich.dream.shared.foundation.decompose.lifecycle.ExtendedLifecycle
import com.arkivanov.decompose.ComponentContext

abstract class ViewComponentAbs<out State : Any, in Intent, out SideEffect>(
    componentContext: ComponentContext
) : MVIComponentAbs<State, Intent, SideEffect>(
    componentContext = componentContext
),
    ViewComponent<State, Intent, SideEffect> {

    override val lifecycle: ExtendedLifecycle = ComponentExtendedLifecycle(
        componentLifecycle = componentContext.lifecycle
    )

    override fun onViewCreated() {
        lifecycle.onViewCreated()
    }

    override fun onViewDestroyed() {
        lifecycle.onViewDestroyed()
    }
}