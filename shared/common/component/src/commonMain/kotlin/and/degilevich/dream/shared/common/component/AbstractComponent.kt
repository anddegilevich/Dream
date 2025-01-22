package and.degilevich.dream.shared.common.component

import and.degilevich.dream.shared.foundation.decompose.lifecycle.ComponentExtendedLifecycle
import and.degilevich.dream.shared.foundation.decompose.lifecycle.ExtendedLifecycle
import com.arkivanov.decompose.ComponentContext

abstract class AbstractComponent<State : Any, Intent, SideEffect>(
    componentContext: ComponentContext
) : Component<State, Intent, SideEffect>, ComponentContext by componentContext {

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