package and.degilevich.dream.shared.foundation.filepicker

import and.degilevich.dream.shared.foundation.filepicker.state.FilePickerState
import and.degilevich.dream.shared.foundation.filepicker.file.PickedFile
import and.degilevich.dream.shared.foundation.filepicker.state.FilePickerValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun FilePicker(
    state: FilePickerState,
    onFilePicked: (PickedFile) -> Unit
) {
    val stateValue by remember { state.value }

    when (val value = stateValue) {
        is FilePickerValue.Closed -> return
        is FilePickerValue.Displayed -> {
            OpenFilePickerSideEffect(
                config = value.config,
                onFilePicked = { pickedFile ->
                    pickedFile.onSuccess(onFilePicked)
                    state.close()
                }
            )
        }
    }
}