package and.degilevich.dream.shared.foundation.compose.modifier.clickable

import and.degilevich.dream.shared.foundation.dispatcher.ext.coroutine.withBackgroundContext
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun InteractionSource.isPressedWithDelay(
    delay: Duration = 150.milliseconds,
): State<Boolean> {
    val isPressed = remember { mutableStateOf(false) }
    val mutex = remember { Mutex() }

    LaunchedEffect(this) {
        interactions.collectLatest { interaction ->
            mutex.withLock {
                isPressed.value = when (interaction) {
                    is PressInteraction.Press -> true
                    else -> {
                        withBackgroundContext {
                            delay(delay)
                        }
                        false
                    }
                }
            }
        }
    }
    return isPressed
}