package and.degilevich.dream.shared.foundation.decompose.compose.component

import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun <SideEffect> ComponentSideEffect(
    component: MVIComponent<*, *, SideEffect>,
    handler: suspend (SideEffect) -> Unit
) {
    LaunchedEffect(Unit) {
        component.sideEffect.receiveAsFlow().collect(handler)
    }
}

@Composable
fun <State : Any> MVIComponent<State, *, *>.collectState(): State {
    val state by this.state.collectAsState(
        context = Dispatchers.Main.immediate
    )
    return state
}