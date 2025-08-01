package and.degilevich.dream.shared.foundation.compose.draggable

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import kotlinx.coroutines.CoroutineScope

@Composable
fun OnDragLaunchedEffect(
    interactionSource: InteractionSource,
    block: suspend CoroutineScope.() -> Unit,
) {
    val isDragged by interactionSource.collectIsDraggedAsState()

    LaunchedEffect(isDragged) {
        if (isDragged) {
            block()
        }
    }
}