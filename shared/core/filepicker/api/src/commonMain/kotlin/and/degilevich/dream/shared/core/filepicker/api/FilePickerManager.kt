package and.degilevich.dream.shared.core.filepicker.api

import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest

interface FilePickerManager {
    suspend fun subscribeToResult(
        key: String,
        onResult: (uris: List<String>) -> Unit
    )

    suspend fun openFilePicker(request: FilePickerRequest)
}