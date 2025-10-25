package and.degilevich.dream.shared.foundation.decompose.component.mvi

import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

abstract class BinderComponent<
    out UIState : Any,
    in Intent : Any,
    out SideEffect : Any,
    State : Any
    >(
    componentContext: ComponentContext,
    domainComponentFactory: (childComponentContext: ComponentContext) -> MVIComponent<State, Intent, SideEffect>,
    uiStateMapper: Mapper<State, UIState>,
    initialUIState: UIState,
) : MVIComponent<UIState, Intent, SideEffect>, ComponentContext by componentContext {

    private val scope: CoroutineScope = coroutineScope()

    private val domainComponent: MVIComponent<State, Intent, SideEffect> = domainComponentFactory(
        childContext(
            key = STORE_COMPONENT_CHILD_KEY
        )
    )

    override val state: StateFlow<UIState> = domainComponent.state
        .map(uiStateMapper::map)
        .flowOn(context = Dispatchers.Default)
        .stateIn(
            scope = scope,
            started = SharingStarted.Lazily,
            initialValue = initialUIState
        )

    override val sideEffect: Flow<SideEffect> = domainComponent.sideEffect

    override fun handleIntent(intent: Intent) {
        domainComponent.handleIntent(intent)
    }

    private companion object Companion {
        const val STORE_COMPONENT_CHILD_KEY = "store"
    }
}