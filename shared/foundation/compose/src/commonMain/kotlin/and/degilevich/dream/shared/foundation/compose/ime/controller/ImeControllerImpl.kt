package and.degilevich.dream.shared.foundation.compose.ime.controller

import androidx.compose.ui.platform.SoftwareKeyboardController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

internal class ImeControllerImpl(
    private val softwareKeyboardController: SoftwareKeyboardController?,
    isVisibleIme: Boolean
) : ImeController {

    private val mutex = Mutex()
    private val isVisibleImeMutable: MutableStateFlow<Boolean> = MutableStateFlow(isVisibleIme)
    private val isVisibleIme: StateFlow<Boolean> = isVisibleImeMutable.asStateFlow()

    suspend fun handleImeVisibility(isVisible: Boolean) {
        mutex.withLock {
            isVisibleImeMutable.value = isVisible
        }
    }

    // FIXME: Modify method so it is suspending until keyboard is fully displayed.
    override suspend fun show() {
        softwareKeyboardController?.show()
        isVisibleIme.first { isVisible -> isVisible }
    }

    override suspend fun hide() {
        softwareKeyboardController?.hide()
        isVisibleIme.first { isVisible -> !isVisible }
    }
}