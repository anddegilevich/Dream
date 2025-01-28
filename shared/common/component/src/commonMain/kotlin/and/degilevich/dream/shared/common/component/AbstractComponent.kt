package and.degilevich.dream.shared.common.component

import and.degilevich.dream.shared.foundation.decompose.lifecycle.ComponentExtendedLifecycle
import and.degilevich.dream.shared.foundation.decompose.lifecycle.ExtendedLifecycle
import and.degilevich.dream.shared.foundation.dispatcher.DefaultKMPDispatchers
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope

abstract class AbstractComponent<State : Any, Intent, SideEffect>(
    componentContext: ComponentContext
) : Component<State, Intent, SideEffect>, ComponentContext by componentContext {

    protected val coroutineContext by lazy {
        coroutineScope(
            context = DefaultKMPDispatchers.main
        )
    }

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