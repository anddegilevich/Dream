package and.degilevich.dream.shared.foundation.compose.click

import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlin.time.TimeMark
import kotlin.time.TimeSource

@Composable
fun rememberDebounced(
    debounceDuration: Duration = DEFAULT_DEBOUNCE,
    block: () -> Unit
): () -> Unit {
    val onClickedDebounced by rememberUpdatedState(block)
    return remember(debounceDuration) {
        var lastMark: TimeMark? = null
        val onClick: () -> Unit = {
            val mark = lastMark
            if (mark == null || mark.elapsedNow() >= debounceDuration) {
                lastMark = TimeSource.Monotonic.markNow()
                onClickedDebounced()
            }
        }
        onClick
    }
}

private val DEFAULT_DEBOUNCE = 600.milliseconds

@Preview
@Composable
private fun RememberDebouncedPreview() {
    val interactionSource = remember { MutableInteractionSource() }
    var onClicksCallsCount by remember { mutableIntStateOf(0) }
    val onSpacerClicked = rememberDebounced(debounceDuration = 1.seconds) {
        onClicksCallsCount++
    }

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
        Space(height = 12.dp)
        Spacer(
            modifier = Modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onSpacerClicked
                )
                .scaleOnClick(interactionSource = interactionSource)
                .size(200.dp)
                .background(Color.Red)
        )
    }
}