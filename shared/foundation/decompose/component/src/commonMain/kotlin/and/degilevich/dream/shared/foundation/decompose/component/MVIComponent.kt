package and.degilevich.dream.shared.foundation.decompose.component

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MVIComponent<out State : Any, in Intent, out SideEffect> {
    val state: StateFlow<State>
    val sideEffect: Flow<SideEffect>

    fun handleIntent(intent: Intent)
}