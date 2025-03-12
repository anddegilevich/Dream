package and.degilevich.dream.shared.foundation.filepicker

import and.degilevich.dream.shared.foundation.filepicker.file.PickedFile
import and.degilevich.dream.shared.foundation.filepicker.file.PickedFileImpl
import and.degilevich.dream.shared.foundation.filepicker.state.FilePickerState
import and.degilevich.dream.shared.foundation.filepicker.state.FilePickerValue
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
actual fun FilePicker(
    state: FilePickerState,
    onFilePicked: (PickedFile) -> Unit
) {
    val stateValue by remember { state.value }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri ->
        uri?.let {
            val file = PickedFileImpl(
                key = stateValue.key,
                uri = uri
            )
            onFilePicked(file)
        }
        state.reset()
    }

    LaunchedEffect(stateValue) {
        when (val value = stateValue) {
            is FilePickerValue.Displayed -> {
                launcher.launch(
                    value.config.mimeTypes.toTypedArray()
                )
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