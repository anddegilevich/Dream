package and.degilevich.dream.shared.foundation.decompose.component.store.storeFactory

import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.mvikotlin.core.store.Store

interface ComponentStoreFactory<State : Any, in Intent : Any, out SideEffect : Any> {
    fun create(
        initialState: State,
        lifecycle: Lifecycle
    ): Store<Intent, State, SideEffect>
}