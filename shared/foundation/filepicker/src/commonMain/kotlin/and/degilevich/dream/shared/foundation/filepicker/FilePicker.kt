package and.degilevich.dream.shared.foundation.filepicker

import and.degilevich.dream.shared.foundation.filepicker.file.PickedFile
import and.degilevich.dream.shared.foundation.filepicker.state.FilePickerState
import androidx.compose.runtime.Composable

@Composable
expect fun FilePicker(
    state: FilePickerState,
    onFilesPicked: (List<PickedFile>) -> Unit
)