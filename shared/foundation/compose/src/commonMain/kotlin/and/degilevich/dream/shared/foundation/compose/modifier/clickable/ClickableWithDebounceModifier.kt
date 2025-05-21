package and.degilevich.dream.shared.foundation.compose.modifier.clickable

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
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

fun Modifier.clickableWithDebounce(
    isEnabled: Boolean = true,
    debounceDuration: Duration = defaultDebounceDuration,
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
                if (mutex.tryLock()) {
                    try {
                        isDebounce = true
                        onClicked()
                        delay(debounceDuration)
                        isDebounce = false
                    } finally {
                        mutex.unlock()
                    }
                }
            }
        }
    }
}

private val defaultDebounceDuration = 650.milliseconds