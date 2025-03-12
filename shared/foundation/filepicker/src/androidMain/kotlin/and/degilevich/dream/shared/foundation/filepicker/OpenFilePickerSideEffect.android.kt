package and.degilevich.dream.shared.foundation.filepicker

import and.degilevich.dream.shared.foundation.filepicker.file.PickedFile
import and.degilevich.dream.shared.foundation.filepicker.file.PickedFileImpl
import and.degilevich.dream.shared.foundation.filepicker.state.FilePickerConfig
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
internal actual fun OpenFilePickerSideEffect(
    config: FilePickerConfig,
    onFilePicked: (Result<PickedFile>) -> Unit
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri ->
        val result = uri?.let {
            Result.success(PickedFileImpl(uri))
        } ?: Result.failure(
            Exception("Failed to get file uri")
        )
        onFilePicked(
            result
        )
    }

    LaunchedEffect(config) {
        launcher.launch(config.mimeTypes.toTypedArray())
    }
}