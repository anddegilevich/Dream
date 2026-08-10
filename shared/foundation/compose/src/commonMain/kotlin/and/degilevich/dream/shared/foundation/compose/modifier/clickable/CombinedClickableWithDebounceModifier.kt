package and.degilevich.dream.shared.foundation.compose.modifier.clickable

import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

fun Modifier.combinedClickableWithDebounce(
    isEnabled: Boolean = true,
    debounceDuration: Duration = defaultCombinedClickableDebounceDuration,
    interactionSource: MutableInteractionSource? = null,
    indication: Indication? = null,
    onLongClicked: suspend () -> Unit = { },
    onDoubleClicked: suspend () -> Unit = { },
    onClicked: suspend () -> Unit
): Modifier {
    return composed {
        val mutex = remember { Mutex() }
        var isDebounce by remember { mutableStateOf(false) }
        val coroutineScope = rememberCoroutineScope()

        fun withDebounce(block: suspend () -> Unit) = coroutineScope.launch {
            if (mutex.tryLock()) {
                try {
                    isDebounce = true
                    block()
                    delay(debounceDuration)
                } finally {
                    isDebounce = false
                    mutex.unlock()
                }
            }
        }

        this.combinedClickable(
            enabled = isEnabled && !isDebounce,
            interactionSource = interactionSource,
            indication = indication,
            onLongClick = { withDebounce { onLongClicked() } },
            onDoubleClick = { withDebounce { onDoubleClicked() } },
            onClick = { withDebounce { onClicked() } }
        )
    }
}

@Preview
@Composable
private fun CombinedClickableWithDebounceModifierPreview() {
    val interactionSource = remember { MutableInteractionSource() }
    var onClicksCallsCount by remember { mutableIntStateOf(0) }
    var onLongClicksCallsCount by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "On click calls count: $onClicksCallsCount"
        )
        Text(
            text = "On long click calls count: $onLongClicksCallsCount"
        )
        Spacer(modifier = Modifier.height(12.dp))
        Spacer(
            modifier = Modifier
                .combinedClickableWithDebounce(
                    debounceDuration = 1.seconds,
                    interactionSource = interactionSource,
                    onLongClicked = { onLongClicksCallsCount++ }
                ) {
                    onClicksCallsCount++
                }
                .scaleOnClick(interactionSource = interactionSource)
                .size(200.dp)
                .background(Color.Red)
        )
    }
}

private val defaultCombinedClickableDebounceDuration = 650.milliseconds