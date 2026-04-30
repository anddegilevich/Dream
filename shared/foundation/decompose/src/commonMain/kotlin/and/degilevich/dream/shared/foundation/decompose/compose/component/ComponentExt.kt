package and.degilevich.dream.shared.foundation.decompose.compose.component

import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.Dispatchers

@Composable
fun <SideEffect : Any> ComponentSideEffect(
    component: MVIComponent<*, *, SideEffect>,
    handler: suspend (SideEffect) -> Unit
) {
    val handler by rememberUpdatedState(handler)

    LaunchedEffect(component) {
        component.sideEffect.collect(handler)
    }
}

@Composable
fun <State : Any> MVIComponent<State, *, *>.state(): State {
    val state by this.state.collectAsState(
        context = Dispatchers.Main.immediate
    )
    return state
}