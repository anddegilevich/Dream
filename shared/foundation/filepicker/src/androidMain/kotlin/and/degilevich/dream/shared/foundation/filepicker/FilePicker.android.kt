package and.degilevich.dream.shared.foundation.filepicker

import and.degilevich.dream.shared.foundation.filepicker.launcher.rememberFilePickerLauncher
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult
import and.degilevich.dream.shared.foundation.filepicker.state.FilePickerState
import and.degilevich.dream.shared.foundation.filepicker.state.FilePickerValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
actual fun FilePicker(
    state: FilePickerState,
    onResult: (FilePickerResult) -> Unit
) {
    val stateValue by remember { state.value }
    var lastKey by rememberSaveable { mutableStateOf("") }
    val filePickerLauncher = rememberFilePickerLauncher { pickedUris ->
        val result = FilePickerResult(
            key = lastKey,
            uris = pickedUris.map { uri ->
                uri.toString()
            }
        )
        onResult(result)
        lastKey = ""
        state.reset()
    }

    LaunchedEffect(stateValue) {
        when (val value = stateValue) {
            is FilePickerValue.Launched -> {
                lastKey = value.request.key
            }

            is FilePickerValue.Closed -> Unit
        }
    }
    LaunchedEffect(stateValue) {
        when (val value = stateValue) {
            is FilePickerValue.Launched -> {
                filePickerLauncher.launch(request = value.request)
            }

            is FilePickerValue.Closed -> Unit
        }
    }
    DisposableEffect(Unit) {
        state.reset()
        onDispose {
            state.reset()
        }
    }
}