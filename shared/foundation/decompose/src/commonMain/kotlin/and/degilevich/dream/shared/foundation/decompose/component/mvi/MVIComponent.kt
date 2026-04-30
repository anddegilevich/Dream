package and.degilevich.dream.shared.foundation.decompose.component.mvi

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Stable
interface MVIComponent<out State : Any, in Intent : Any, out SideEffect : Any> {
    val state: StateFlow<State>
    val sideEffect: Flow<SideEffect>

    fun handleIntent(intent: Intent)
}