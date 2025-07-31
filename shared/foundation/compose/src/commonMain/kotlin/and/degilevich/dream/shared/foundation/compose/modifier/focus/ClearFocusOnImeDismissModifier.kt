package and.degilevich.dream.shared.foundation.compose.modifier.focus

import and.degilevich.dream.shared.foundation.compose.ime.rememberIsVisibleIme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalFocusManager

fun Modifier.clearFocusOnImeDismiss(): Modifier {
    return this.composed {
        var isFocused by remember { mutableStateOf(false) }
        var hasAppearedKeyboardSinceLastFocused by remember { mutableStateOf(false) }
        val isVisibleIme by rememberIsVisibleIme()
        val focusManager = LocalFocusManager.current

        LaunchedEffect(isFocused, isVisibleIme) {
            when {
                !isFocused -> Unit
                isVisibleIme -> hasAppearedKeyboardSinceLastFocused = true
                hasAppearedKeyboardSinceLastFocused -> focusManager.clearFocus()
            }
        }

        onFocusEvent { focusState ->
            if (isFocused == focusState.isFocused) return@onFocusEvent
            isFocused = focusState.isFocused
            if (isFocused) {
                hasAppearedKeyboardSinceLastFocused = false
            }
        }
    }
}