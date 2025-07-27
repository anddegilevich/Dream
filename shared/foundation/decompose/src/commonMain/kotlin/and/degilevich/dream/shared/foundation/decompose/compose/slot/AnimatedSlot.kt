package and.degilevich.dream.shared.foundation.decompose.compose.slot

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.router.slot.ChildSlot

@Composable
fun <C : Any, T : Any> ColumnScope.AnimatedSlot(
    slot: ChildSlot<C, T>,
    modifier: Modifier = Modifier,
    enter: EnterTransition = fadeIn() + expandVertically(),
    exit: ExitTransition = fadeOut() + shrinkVertically(),
    content: @Composable (child: Child.Created<C, T>) -> Unit,
) {
    val child = slot.child
    var childContent: @Composable ColumnScope.() -> Unit by remember { mutableStateOf({ }) }

    DisposableEffect(child) {
        if (child != null) {
            childContent = { content(child) }
        }
        onDispose {}
    }

    AnimatedVisibility(
        modifier = modifier,
        visible = child != null,
        enter = enter,
        exit = exit
    ) {
        childContent()
    }
}