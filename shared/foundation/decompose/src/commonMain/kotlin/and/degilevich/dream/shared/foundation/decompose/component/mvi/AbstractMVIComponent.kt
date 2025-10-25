package and.degilevich.dream.shared.foundation.decompose.component.mvi

import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.arkivanov.essenty.lifecycle.coroutines.withLifecycle
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

abstract class AbstractMVIComponent<State : Any, in Intent : Any, SideEffect : Any>(
    componentContext: ComponentContext,
    stateConservator: ComponentStateConservator<State>,
) : MVIComponent<State, Intent, SideEffect>, ComponentContext by componentContext {

    protected val scope = coroutineScope()

    private val mutableState = MutableStateFlow(
        value = componentContext.stateKeeper.consume(
            key = stateConservator.key,
            strategy = stateConservator.serializer
        ) ?: stateConservator.initialState,
    )
    private val sideEffectChannel = Channel<SideEffect>(capacity = Channel.BUFFERED)

    override val state: StateFlow<State> = mutableState
        .withLifecycle(
            lifecycle = lifecycle,
            context = scope.coroutineContext
        ).stateIn(
            scope = scope,
            started = SharingStarted.Lazily,
            initialValue = stateConservator.initialState
        )

    override val sideEffect: Flow<SideEffect> = sideEffectChannel
        .receiveAsFlow()
        .withLifecycle(
            lifecycle = lifecycle,
            context = scope.coroutineContext
        )

    init {
        registerState(stateConservator)
    }

    private fun registerState(stateConservator: ComponentStateConservator<State>) {
        stateKeeper.register(
            key = stateConservator.key,
            strategy = stateConservator.serializer
        ) { state() }
    }

    override fun handleIntent(intent: Intent) = Unit

    protected fun state(): State {
        return mutableState.value
    }

    protected fun reduce(block: State.() -> State) {
        mutableState.update(block)
    }

    protected suspend fun publish(effect: SideEffect) {
        sideEffectChannel.send(effect)
    }
}