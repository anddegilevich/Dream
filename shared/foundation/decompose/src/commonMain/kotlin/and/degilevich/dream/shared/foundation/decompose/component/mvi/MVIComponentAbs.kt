package and.degilevich.dream.shared.foundation.decompose.component.mvi

import and.degilevich.dream.shared.foundation.coroutine.dispatcher.DefaultKMPDispatchers
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope

abstract class MVIComponentAbs<out State : Any, in Intent, out SideEffect>(
    componentContext: ComponentContext
) : MVIComponent<State, Intent, SideEffect>, ComponentContext by componentContext {

    protected val coroutineScope by lazy {
        coroutineScope(
            context = DefaultKMPDispatchers.main
        )
    }
}