package and.degilevich.dream.shared.foundation.decompose.compose.slot

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetDefaults
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.value.Value

@Composable
fun <C : Any, T : Any> SlotBottomSheetLayout(
    slot: Value<ChildSlot<C, T>>,
    onDismiss: () -> Unit,
    sheetContent: @Composable (child: Child.Created<C, T>) -> Unit,
    modifier: Modifier = Modifier,
    sheetState: ModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden),
    sheetGesturesEnabled: Boolean = true,
    sheetShape: Shape = MaterialTheme.shapes.large,
    sheetElevation: Dp = ModalBottomSheetDefaults.Elevation,
    sheetBackgroundColor: Color = MaterialTheme.colors.surface,
    content: @Composable () -> Unit
) {

    val slotState by slot.subscribeAsState()
    val child: Child.Created<C, T>? = slotState.child
    val isVisibleChild = remember(child) { child != null }
    var childContent by remember { mutableStateOf(emptyContent) }

    LaunchedEffect(sheetState.targetValue) {
        if (sheetState.targetValue == ModalBottomSheetValue.Hidden) {
            onDismiss()
        }
    }
    LaunchedEffect(isVisibleChild) {
        if (!isVisibleChild) {
            sheetState.hide()
            childContent = emptyContent
        } else {
            sheetState.show()
        }
    }

    DisposableEffect(child) {
        if (child != null) {
            childContent = {
                sheetContent(child)
            }
        }
        onDispose {}
    }

    ModalBottomSheetLayout(
        modifier = modifier,
        sheetContent = childContent,
        sheetState = sheetState,
        sheetGesturesEnabled = sheetGesturesEnabled,
        sheetShape = sheetShape,
        sheetElevation = sheetElevation,
        sheetBackgroundColor = sheetBackgroundColor,
        content = content
    )
}

private val emptyContent: @Composable ColumnScope.() -> Unit = {
    Spacer(Modifier.height(1.dp))
}