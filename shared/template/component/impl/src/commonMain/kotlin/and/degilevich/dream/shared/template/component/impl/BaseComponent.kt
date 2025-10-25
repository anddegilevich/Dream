package and.degilevich.dream.shared.template.component.impl

import and.degilevich.dream.shared.template.component.impl.logger.LoggerComponentLifecycleCallbacks
import com.arkivanov.decompose.ComponentContext

abstract class BaseComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    init {
        logLifecycleChanges(this::class.simpleName.orEmpty())
    }

    private fun logLifecycleChanges(componentKey: String) {
        lifecycle.subscribe(
            callbacks = LoggerComponentLifecycleCallbacks(componentKey = componentKey)
        )
    }
}