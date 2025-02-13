package and.degilevich.dream.shared.app.api.compose.ext

import and.degilevich.dream.shared.foundation.decompose.component.MVIComponent
import and.degilevich.dream.shared.foundation.dispatcher.DefaultKMPDispatchers
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun <SideEffect> MVIComponent<*, *, SideEffect>.HandleSideEffect(handler: (SideEffect) -> Unit) {
    LaunchedEffect(Unit) {
        sideEffect.collect(handler)
    }
}

@Composable
fun <State : Any> MVIComponent<State, *, *>.collectState(): State {
    val state by this.state.collectAsState(
        context = DefaultKMPDispatchers.main
    )
    return state
}