package and.degilevich.dream.shared.foundation.decompose.component.store.reducer

import com.arkivanov.mvikotlin.core.store.Reducer

internal class UniversalReducer<State> : Reducer<State, ReduceMessage<State>> {
    override fun State.reduce(msg: ReduceMessage<State>): State {
        return msg.block(this)
    }
}