package and.degilevich.dream.shared.common.component

import and.degilevich.dream.shared.common.component.lifecycle.ExtendedLifecycle
import and.degilevich.dream.shared.common.component.lifecycle.view.ViewLifecycleCallbacks
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface Component<State, Intent, SideEffect> : ViewLifecycleCallbacks {
    val state: StateFlow<State>
    val sideEffect: Flow<Intent>
    val lifecycle: ExtendedLifecycle

    fun handleIntent(intent: SideEffect)
}