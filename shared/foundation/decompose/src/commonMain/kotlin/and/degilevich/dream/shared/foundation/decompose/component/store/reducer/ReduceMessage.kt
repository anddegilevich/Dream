package and.degilevich.dream.shared.foundation.decompose.component.store.reducer

data class ReduceMessage<State>(
    val block: State.() -> State
)