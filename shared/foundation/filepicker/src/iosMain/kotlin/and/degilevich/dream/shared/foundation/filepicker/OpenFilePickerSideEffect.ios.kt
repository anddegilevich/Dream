package and.degilevich.dream.shared.foundation.filepicker

import and.degilevich.dream.shared.foundation.filepicker.file.PickedFile
import and.degilevich.dream.shared.foundation.filepicker.state.FilePickerConfig
import androidx.compose.runtime.Composable

@Suppress("EmptyFunctionBlock") //FIXME: Implement later
@Composable
internal actual fun OpenFilePickerSideEffect(
    config: FilePickerConfig,
    onFilePicked: (Result<PickedFile>) -> Unit
) {
}