package and.degilevich.dream.shared.foundation.decompose.component

import and.degilevich.dream.shared.foundation.dispatcher.DefaultKMPDispatchers
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope

abstract class AbstractMVIComponent<State : Any, Intent, SideEffect>(
    componentContext: ComponentContext
) : MVIComponent<State, Intent, SideEffect>, ComponentContext by componentContext {

    protected val coroutineScope by lazy {
        coroutineScope(
            context = DefaultKMPDispatchers.main
        )
    }
}