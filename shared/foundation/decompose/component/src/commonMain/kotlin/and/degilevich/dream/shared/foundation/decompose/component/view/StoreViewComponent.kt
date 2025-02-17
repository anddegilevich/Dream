package and.degilevich.dream.shared.foundation.decompose.component.view

import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.decompose.component.mvi.storeFactory.ComponentStoreFactory
import and.degilevich.dream.shared.foundation.model.mapper.Mapper
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnStart
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.states
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class StoreViewComponent<
    out UIState : Any,
    in Intent : Any,
    out SideEffect : Any,
    State : Any,
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

    private val currentDomainStateChannel = Channel<State>()
    private val uiStateFlow = merge(
        currentDomainStateChannel.receiveAsFlow(),
        store.states
    ).map(uiStateMapper::map)

    override val state: StateFlow<UIState> = uiStateFlow.stateIn(
        scope = coroutineScope,
        started = SharingStarted.Lazily,
        initialValue = initialUIState
    )

    override val sideEffect: Flow<SideEffect> = store.labels

    init {
        registerState(stateConservator)
        subscribeToLifecycle()
    }

    private fun registerState(stateConservator: ComponentStateConservator<State>) {
        componentContext.stateKeeper.register(
            key = stateConservator.key,
            strategy = stateConservator.serializer
        ) { store.state }
    }

    private fun subscribeToLifecycle() {
        doOnStart {
            refreshDomainState()
        }
    }

    private fun refreshDomainState() {
        coroutineScope.launch {
            currentDomainStateChannel.send(store.state)
        }
    }

    override fun handleIntent(intent: Intent) {
        store.accept(intent)
    }
}