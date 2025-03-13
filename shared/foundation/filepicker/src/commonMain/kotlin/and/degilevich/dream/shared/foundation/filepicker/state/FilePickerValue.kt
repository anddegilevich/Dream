package and.degilevich.dream.shared.foundation.filepicker.state

import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest

internal sealed interface FilePickerValue {

    val key: String

    data object Closed : FilePickerValue {
        override val key: String = ""
    }

    data class Launched(
        val request: FilePickerRequest,
    ) : FilePickerValue {
        override val key: String = request.key
    }
}