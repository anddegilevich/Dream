package and.degilevich.dream.shared.foundation.decompose.component.mvi

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MVIComponent<out State : Any, in Intent, out SideEffect> : ComponentContext {
    val state: StateFlow<State>
    val sideEffect: Flow<SideEffect>

    fun handleIntent(intent: Intent)
}