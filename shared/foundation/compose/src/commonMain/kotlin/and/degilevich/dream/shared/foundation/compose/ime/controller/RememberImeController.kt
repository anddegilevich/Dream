package and.degilevich.dream.shared.foundation.compose.ime.controller

import and.degilevich.dream.shared.foundation.compose.ime.rememberIsVisibleIme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

@Composable
fun rememberImeController(): ImeController {
    val isVisibleIme by rememberIsVisibleIme()
    val softwareKeyboardController = LocalSoftwareKeyboardController.current
    val keyboardController = remember(softwareKeyboardController) {
        ImeControllerImpl(
            softwareKeyboardController = softwareKeyboardController,
            isVisibleIme = isVisibleIme
        )
    }

    LaunchedEffect(isVisibleIme) {
        keyboardController.handleImeVisibility(isVisibleIme)
    }

    return keyboardController
}