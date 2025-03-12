package and.degilevich.dream.shared.foundation.decompose.component.store.storeFactory

import and.degilevich.dream.shared.foundation.decompose.component.store.reducer.ReduceMessage
import and.degilevich.dream.shared.foundation.decompose.component.store.reducer.ReducerImpl
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.mvikotlin.core.store.Executor
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory

abstract class ComponentStoreFactoryAbs<State : Any, in Intent : Any, out SideEffect : Any>(
    private val storeFactory: StoreFactory,
    private val storeName: String,
    private val executorFactory: (Lifecycle) -> Executor<Intent, Nothing, State, ReduceMessage<State>, SideEffect>,
) : ComponentStoreFactory<State, Intent, SideEffect> {
    final override fun create(
        initialState: State,
        lifecycle: Lifecycle
    ): Store<Intent, State, SideEffect> {
        return storeFactory.create(
            name = storeName,
            initialState = initialState,
            executorFactory = { executorFactory(lifecycle) },
            reducer = ReducerImpl()
        )
    }
}