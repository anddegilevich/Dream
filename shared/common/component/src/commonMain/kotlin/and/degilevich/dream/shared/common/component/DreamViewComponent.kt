package and.degilevich.dream.shared.common.component

import and.degilevich.dream.shared.foundation.decompose.component.view.AbstractViewComponent
import and.degilevich.dream.shared.core.logger.Log
import com.arkivanov.decompose.ComponentContext

abstract class DreamViewComponent<out State : Any, in Intent, out SideEffect>(
    componentContext: ComponentContext
) : AbstractViewComponent<State, Intent, SideEffect>(componentContext = componentContext) {

    init {
        logLifecycleChanges()
    }

    private fun logLifecycleChanges() {
        lifecycle.subscribe(
            onCreate = {
                Log.info("OnCreate")
            }
        )
    }
}