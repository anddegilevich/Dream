package and.degilevich.dream.shared.common.component

import and.degilevich.dream.shared.foundation.decompose.lifecycle.ExtendedLifecycle
import and.degilevich.dream.shared.foundation.decompose.lifecycle.view.ViewLifecycleCallbacks
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.Flow

interface Component<State : Any, Intent, SideEffect> : ViewLifecycleCallbacks {
    val state: Value<State>
    val sideEffect: Flow<Intent>
    val lifecycle: ExtendedLifecycle

    fun handleIntent(intent: SideEffect)
}