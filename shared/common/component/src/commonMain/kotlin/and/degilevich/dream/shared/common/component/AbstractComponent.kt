package and.degilevich.dream.shared.common.component

import and.degilevich.dream.shared.common.component.lifecycle.ExtendedLifecycle
import and.degilevich.dream.shared.common.component.lifecycle.ExtendedLifecycleImpl
import com.arkivanov.decompose.ComponentContext

abstract class AbstractComponent<State, Intent, SideEffect>(
    componentContext: ComponentContext
) : Component<State, Intent, SideEffect>, ComponentContext by componentContext {

    override val lifecycle: ExtendedLifecycle = ExtendedLifecycleImpl(
        componentLifecycle = componentContext.lifecycle
    )

    override fun onViewCreated() {
        lifecycle.onViewCreated()
    }

    override fun onViewDestroyed() {
        lifecycle.onViewDestroyed()
    }
}