package and.degilevich.dream.shared.compose.foundation.modifier.clickable

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

fun Modifier.clickableWithDebounce(
    isEnabled: Boolean = true,
    debounceDuration: Duration = 650.milliseconds,
    interactionSource: MutableInteractionSource? = null,
    indication: Indication? = null,
    onClicked: suspend () -> Unit
): Modifier {
    return composed {
        val mutex = remember { Mutex() }
        var isDebounce by remember { mutableStateOf(false) }
        val coroutineScope = rememberCoroutineScope()

        this.clickable(
            enabled = isEnabled && !isDebounce,
            interactionSource = interactionSource,
            indication = indication
        ) {
            coroutineScope.launch {
                if (mutex.isLocked) return@launch
                mutex.withLock {
                    onClicked()
                    delay(debounceDuration)
                }
            }
        }
    }
}