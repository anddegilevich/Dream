package and.degilevich.dream.shared.foundation.decompose.component.store

import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponentAbs
import and.degilevich.dream.shared.foundation.decompose.component.store.conservator.StoreStateConservator
import and.degilevich.dream.shared.foundation.decompose.component.store.storeFactory.ComponentStoreFactory
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

abstract class StoreComponent<
    out State : Any,
    in Intent : Any,
    out SideEffect : Any
    >(
    componentContext: ComponentContext,
    storeFactory: ComponentStoreFactory<State, Intent, SideEffect>,
    stateConservator: StoreStateConservator<State>,
) : MVIComponentAbs<State, Intent, SideEffect>(componentContext) {

    private val store: Store<Intent, State, SideEffect> = storeFactory.create(
        initialState = componentContext.stateKeeper.consume(
            key = stateConservator.key,
            strategy = stateConservator.serializer
        ) ?: stateConservator.initialState,
        lifecycle = componentContext.lifecycle
    )

    override val state: StateFlow<State> = store.stateFlow(
        scope = componentScope,
        started = SharingStarted.Lazily
    )

    override val sideEffect: Flow<SideEffect> = store.labels

    override fun handleIntent(intent: Intent) {
        store.accept(intent)
    }

    init {
        registerState(stateConservator)
    }

    private fun registerState(stateConservator: StoreStateConservator<State>) {
        stateKeeper.register(
            key = stateConservator.key,
            strategy = stateConservator.serializer
        ) { store.state }
    }
}