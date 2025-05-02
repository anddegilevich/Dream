package and.degilevich.dream.shared.foundation.decompose.component.store.reducer

import com.arkivanov.mvikotlin.core.store.Reducer

class DefaultReducer<State> : Reducer<State, ReduceMessage<State>> {
    override fun State.reduce(msg: ReduceMessage<State>): State {
        return msg.block(this)
    }
}