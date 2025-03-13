package and.degilevich.dream.shared.core.filepicker.api

import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult

interface FilePickerManager {
    suspend fun subscribeToResult(onResult: (FilePickerResult) -> Unit)
    suspend fun openFilePicker(request: FilePickerRequest)
}