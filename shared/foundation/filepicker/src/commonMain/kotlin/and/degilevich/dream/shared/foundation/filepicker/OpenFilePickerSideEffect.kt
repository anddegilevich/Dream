package and.degilevich.dream.shared.foundation.filepicker

import and.degilevich.dream.shared.foundation.filepicker.state.FilePickerConfig
import androidx.compose.runtime.Composable

@Composable
internal expect fun OpenFilePickerSideEffect(
    config: FilePickerConfig
)