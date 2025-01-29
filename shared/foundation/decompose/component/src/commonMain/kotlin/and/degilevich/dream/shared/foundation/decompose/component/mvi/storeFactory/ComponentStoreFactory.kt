package and.degilevich.dream.shared.foundation.decompose.component.mvi.storeFactory

import and.degilevich.dream.shared.foundation.decompose.lifecycle.ExtendedLifecycle
import com.arkivanov.mvikotlin.core.store.Store

interface ComponentStoreFactory<State : Any, Intent : Any, SideEffect : Any> {
    fun create(
        initialState: State,
        lifecycle: ExtendedLifecycle
    ): Store<Intent, State, SideEffect>
}