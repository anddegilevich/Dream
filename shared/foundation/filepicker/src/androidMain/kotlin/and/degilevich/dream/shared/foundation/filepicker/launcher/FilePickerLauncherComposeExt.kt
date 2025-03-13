package and.degilevich.dream.shared.foundation.filepicker.launcher

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
internal fun rememberFilePickerLauncher(
    onResult: (List<Uri>) -> Unit
): FilePickerLauncher {
    val singleFilePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { pickedUri ->
        onResult(
            buildList {
                pickedUri?.let {
                    add(it)
                }
            }
        )
    }
    val multipleFilePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenMultipleDocuments()
    ) { pickedUris ->
        onResult(pickedUris)
    }
    val singleImagePickerLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { pickedUri ->
        onResult(
            buildList {
                pickedUri?.let {
                    add(it)
                }
            }
        )
    }
    val multipleImagePickerLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.PickMultipleVisualMedia()
    ) { pickedUris ->
        onResult(pickedUris)
    }

    return remember {
        FilePickerLauncherImpl(
            singleFilePickerLauncher = singleFilePickerLauncher,
            multipleFilePickerLauncher = multipleFilePickerLauncher,
            singleImagePickerLauncher = singleImagePickerLauncher,
            multipleImagePickerLauncher = multipleImagePickerLauncher
        )
    }
}