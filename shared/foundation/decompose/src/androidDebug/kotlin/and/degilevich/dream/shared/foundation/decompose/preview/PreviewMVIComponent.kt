package and.degilevich.dream.shared.foundation.decompose.preview

import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow

open class PreviewMVIComponent<State : Any, in Intent : Any, out SideEffect : Any>(
    state: State
) : MVIComponent<State, Intent, SideEffect> {

    override val state: StateFlow<State> = MutableStateFlow(state)
    override val sideEffect: Flow<SideEffect> = emptyFlow()
    override fun handleIntent(intent: Intent) = Unit
}