package and.degilevich.dream.shared.common.component

import and.degilevich.dream.shared.foundation.decompose.lifecycle.view.ViewLifecycleCallbacks
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface Component<State : Any, Intent, SideEffect> : ViewLifecycleCallbacks {
    val state: StateFlow<State>
    val sideEffect: Flow<SideEffect>

    fun handleIntent(intent: Intent)
}