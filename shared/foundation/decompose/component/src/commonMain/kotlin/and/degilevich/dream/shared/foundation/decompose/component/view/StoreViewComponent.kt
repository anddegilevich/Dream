package and.degilevich.dream.shared.foundation.decompose.component.view

import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.decompose.component.mvi.storeFactory.ComponentStoreFactory
import and.degilevich.dream.shared.foundation.model.mapper.Mapper
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.states
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

abstract class StoreViewComponent<
    out UIState : Any,
    in Intent : Any,
    out SideEffect : Any,
    out State : Any,
    out Message : Any
    >(
    private val componentContext: ComponentContext,
    storeFactory: ComponentStoreFactory<State, Intent, SideEffect>,
    initialUIState: UIState,
    uiStateMapper: Mapper<State, UIState>,
    stateConservator: ComponentStateConservator<State>,
) : AbstractViewComponent<UIState, Intent, SideEffect>(componentContext) {

    private val store: Store<Intent, State, SideEffect> = componentContext.instanceKeeper.getStore {
        storeFactory.create(
            initialState = stateKeeper.consume(
                key = stateConservator.key,
                strategy = stateConservator.serializer
            ) ?: stateConservator.initialState,
            lifecycle = lifecycle
        )
    }

    override val state: StateFlow<UIState> = store.states
        .map(uiStateMapper::map)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.Lazily,
            initialValue = initialUIState
        )

    override val sideEffect: Flow<SideEffect> = store.labels

    init {
        registerState(stateConservator)
    }

    private fun registerState(stateConservator: ComponentStateConservator<State>) {
        componentContext.stateKeeper.register(
            key = stateConservator.key,
            strategy = stateConservator.serializer
        ) { store.state }
    }

    override fun handleIntent(intent: Intent) {
        store.accept(intent)
    }
}