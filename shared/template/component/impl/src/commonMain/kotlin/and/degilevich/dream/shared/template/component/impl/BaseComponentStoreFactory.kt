package and.degilevich.dream.shared.template.component.impl

import and.degilevich.dream.shared.foundation.decompose.component.store.reducer.DefaultReducer
import and.degilevich.dream.shared.foundation.decompose.component.store.reducer.ReduceMessage
import and.degilevich.dream.shared.foundation.decompose.component.store.storeFactory.ComponentStoreFactory
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.mvikotlin.core.store.Executor
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseComponentStoreFactory<State : Any, in Intent : Any, out SideEffect : Any>(
    private val storeName: String,
    private val executorFactory: (Lifecycle) -> Executor<Intent, Nothing, State, ReduceMessage<State>, SideEffect>,
) : ComponentStoreFactory<State, Intent, SideEffect>, KoinComponent {

    val storeFactory: StoreFactory by inject()

    final override fun create(
        initialState: State,
        lifecycle: Lifecycle
    ): Store<Intent, State, SideEffect> {
        return storeFactory.create(
            name = storeName,
            initialState = initialState,
            executorFactory = { executorFactory(lifecycle) },
            reducer = DefaultReducer()
        )
    }
}