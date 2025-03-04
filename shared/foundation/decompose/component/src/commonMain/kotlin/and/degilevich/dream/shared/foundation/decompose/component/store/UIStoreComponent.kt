package and.degilevich.dream.shared.foundation.decompose.component.store

import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import and.degilevich.dream.shared.foundation.decompose.component.view.ViewComponentAbs
import and.degilevich.dream.shared.foundation.model.mapper.Mapper
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.essenty.lifecycle.doOnStart
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class UIStoreComponent<
    out UIState : Any,
    in Intent : Any,
    out SideEffect : Any,
    State : Any
    >(
    componentContext: ComponentContext,
    storeComponentFactory: (childComponentContext: ComponentContext) -> MVIComponent<State, Intent, SideEffect>,
    initialUIState: UIState,
    uiStateMapper: Mapper<State, UIState>,
) : ViewComponentAbs<UIState, Intent, SideEffect>(componentContext) {

    private val storeComponent: MVIComponent<State, Intent, SideEffect> = storeComponentFactory(
        childContext(key = STORE_COMPONENT_CHILD_KEY)
    )

    private val currentStateChannel = Channel<State>()

    override val state: StateFlow<UIState> = merge(
        currentStateChannel.receiveAsFlow(),
        storeComponent.state
    )
        .map(uiStateMapper::map)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.Lazily,
            initialValue = initialUIState
        )

    override val sideEffect: Flow<SideEffect> = storeComponent.sideEffect

    override fun handleIntent(intent: Intent) {
        storeComponent.handleIntent(intent)
    }

    init {
        subscribeToLifecycle()
    }

    private fun subscribeToLifecycle() {
        doOnStart {
            refreshDomainState()
        }
    }

    //FIXME: Find better way to update locales due to configuration changes
    private fun refreshDomainState() {
        coroutineScope.launch {
            currentStateChannel.send(storeComponent.state.value)
        }
    }

    private companion object {
        const val STORE_COMPONENT_CHILD_KEY = "store"
    }
}