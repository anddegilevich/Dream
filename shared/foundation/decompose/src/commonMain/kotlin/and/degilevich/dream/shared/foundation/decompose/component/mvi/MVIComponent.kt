package and.degilevich.dream.shared.foundation.decompose.component.mvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MVIComponent<out State : Any, in Intent : Any, out SideEffect : Any> {
    val state: StateFlow<State>
    val sideEffect: Flow<SideEffect>

    fun handleIntent(intent: Intent)
}