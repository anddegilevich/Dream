package and.degilevich.dream.shared.foundation.decompose.component.mvi

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.flow.StateFlow

interface MVIComponent<out State : Any, in Intent, out SideEffect> : ComponentContext {
    val state: StateFlow<State>
    val sideEffect: ReceiveChannel<SideEffect>

    fun handleIntent(intent: Intent)
}