package and.degilevich.dream.shared.foundation.decompose.component.store

import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
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

abstract class UIStoreComponent<
    out UIState : Any,
    in Intent : Any,
    out SideEffect : Any,
    State : Any
    >(
    componentContext: ComponentContext,
    storeComponentFactory: (childComponentContext: ComponentContext) -> MVIComponent<State, Intent, SideEffect>,
    uiStateMapper: Mapper<State, UIState>,
    initialUIState: UIState,
) : MVIComponent<UIState, Intent, SideEffect>, ComponentContext by componentContext {

    private val coroutineScope: CoroutineScope = coroutineScope()

    private val storeComponent: MVIComponent<State, Intent, SideEffect> = storeComponentFactory(
        childContext(
            key = STORE_COMPONENT_CHILD_KEY
        )
    )

    override val state: StateFlow<UIState> = storeComponent.state
        .map(uiStateMapper::map)
        .flowOn(context = Dispatchers.Default)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.Lazily,
            initialValue = initialUIState
        )

    override val sideEffect: Flow<SideEffect> = storeComponent.sideEffect

    override fun handleIntent(intent: Intent) {
        storeComponent.handleIntent(intent)
    }

    private companion object {
        const val STORE_COMPONENT_CHILD_KEY = "store"
    }
}