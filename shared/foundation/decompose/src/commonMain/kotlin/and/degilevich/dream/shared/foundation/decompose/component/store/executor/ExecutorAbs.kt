package and.degilevich.dream.shared.foundation.decompose.component.store.executor

import and.degilevich.dream.shared.foundation.decompose.component.store.reducer.ReduceMessage
import and.degilevich.dream.shared.foundation.coroutine.dispatcher.DefaultKMPDispatchers
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.lifecycle.doOnStop
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.cancelChildren

abstract class ExecutorAbs<State : Any, in Intent : Any, SideEffect : Any>(
    override val lifecycle: Lifecycle
) : CoroutineExecutor<
    Intent,
    Nothing,
    State,
    ReduceMessage<State>,
    SideEffect
    >(mainContext = DefaultKMPDispatchers.main),
    LifecycleOwner {

    init {
        doOnStop {
            scope.coroutineContext.cancelChildren()
        }
    }

    protected fun reduce(block: State.() -> State) {
        dispatch(ReduceMessage(block))
    }
}