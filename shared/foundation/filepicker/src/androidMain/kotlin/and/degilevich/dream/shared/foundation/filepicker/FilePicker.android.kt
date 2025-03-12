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
    onFilesPicked: (List<PickedFile>) -> Unit
) {
    val stateValue by remember { state.value }

    val singleFileLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri ->
        onFilesPicked(
            buildList {
                uri?.let {
                    val file = PickedFileImpl(
                        key = stateValue.key,
                        androidUri = uri
                    )
                    add(file)
                }
            }
        )
        state.reset()
    }
    val multipleFileLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenMultipleDocuments()
    ) { uris ->
        onFilesPicked(
            uris.map { uri ->
                PickedFileImpl(
                    key = stateValue.key,
                    androidUri = uri
                )
            }
        )
        state.reset()
    }

    LaunchedEffect(stateValue) {
        when (val value = stateValue) {
            is FilePickerValue.Launched -> {
                val config = value.config
                val mimeTypes = config.mimeTypes.toTypedArray()
                if (config.isMultiselect) {
                    multipleFileLauncher.launch(mimeTypes)
                } else {
                    singleFileLauncher.launch(mimeTypes)
                }
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