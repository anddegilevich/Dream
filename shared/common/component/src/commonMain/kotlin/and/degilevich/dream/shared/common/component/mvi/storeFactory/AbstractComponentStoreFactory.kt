package and.degilevich.dream.shared.common.component.mvi.storeFactory

import and.degilevich.dream.shared.foundation.decompose.lifecycle.ExtendedLifecycle
import com.arkivanov.mvikotlin.core.store.Executor
import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory

abstract class AbstractComponentStoreFactory<State : Any, Intent : Any, SideEffect : Any, Message : Any>(
    private val storeFactory: StoreFactory,
    private val executorFactory: (ExtendedLifecycle) -> Executor<Intent, Nothing, State, Message, SideEffect>,
    private val reducer: Reducer<State, Message>,
) : ComponentStoreFactory<State, Intent, SideEffect> {
    final override fun create(
        initialState: State,
        lifecycle: ExtendedLifecycle
    ): Store<Intent, State, SideEffect> {
        return storeFactory.create(
            initialState = initialState,
            executorFactory = { executorFactory(lifecycle) },
            reducer = reducer
        )
    }
}