package and.degilevich.dream.shared.foundation.decompose.component.store.storeFactory

import and.degilevich.dream.shared.foundation.decompose.lifecycle.ExtendedLifecycle
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import com.arkivanov.mvikotlin.core.store.Executor
import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import kotlin.reflect.KClass

abstract class AbstractComponentStoreFactory<State : Any, in Intent : Any, out SideEffect : Any, in Message : Any>(
    private val storeKClass: KClass<out Store<Intent, State, SideEffect>>,
    private val storeFactory: StoreFactory,
    private val executorFactory: (ExtendedLifecycle) -> Executor<Intent, Nothing, State, Message, SideEffect>,
    private val reducer: Reducer<State, Message>,
) : ComponentStoreFactory<State, Intent, SideEffect> {
    final override fun create(
        initialState: State,
        lifecycle: ExtendedLifecycle
    ): Store<Intent, State, SideEffect> {
        return storeFactory.create(
            name = storeKClass.className(),
            initialState = initialState,
            executorFactory = { executorFactory(lifecycle) },
            reducer = reducer
        )
    }
}