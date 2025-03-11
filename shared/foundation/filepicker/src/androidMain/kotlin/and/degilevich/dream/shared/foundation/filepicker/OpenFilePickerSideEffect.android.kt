package and.degilevich.dream.shared.foundation.filepicker

import and.degilevich.dream.shared.foundation.filepicker.state.FilePickerConfig
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable

@Composable
internal actual fun OpenFilePickerSideEffect(config: FilePickerConfig) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { result ->

    }
}