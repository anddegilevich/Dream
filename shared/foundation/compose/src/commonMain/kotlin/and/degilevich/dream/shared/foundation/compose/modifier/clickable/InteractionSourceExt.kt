package and.degilevich.dream.shared.foundation.compose.modifier.clickable

import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.inHalf
import androidx.compose.animation.core.AnimationConstants.DefaultDurationMillis
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun InteractionSource.isPressedWithDelay(
    delay: Duration = (DefaultDurationMillis.inHalf()).milliseconds,
): Boolean {
    var isPressed by remember { mutableStateOf(false) }

    LaunchedEffect(this) {
        interactions.collect { interaction ->
            isPressed = when (interaction) {
                is PressInteraction.Press -> true
                else -> {
                    delay(delay)
                    false
                }
            }
        }
    }
    return isPressed
}