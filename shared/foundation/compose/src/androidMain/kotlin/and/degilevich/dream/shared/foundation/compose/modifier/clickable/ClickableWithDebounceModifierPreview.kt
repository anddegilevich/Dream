package and.degilevich.dream.shared.foundation.compose.modifier.clickable

import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.background
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.time.Duration.Companion.seconds

@Preview
@Composable
private fun ClickableWithDebounceModifierPreview() {
    val interactionSource = remember { MutableInteractionSource() }
    var onClicksCallsCount by remember { mutableIntStateOf(0) }

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
                .clickableWithDebounce(
                    debounceDuration = 1.seconds,
                    interactionSource = interactionSource
                ) {
                    onClicksCallsCount++
                }
                .scaleOnClick(
                    interactionSource = interactionSource
                )
                .size(200.dp)
                .background(Color.Red)
        )
    }
}