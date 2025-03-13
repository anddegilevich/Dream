package and.degilevich.dream.shared.foundation.filepicker.state

import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest

internal sealed interface FilePickerValue {
    data object Closed : FilePickerValue
    data class Launched(
        val request: FilePickerRequest,
    ) : FilePickerValue
}