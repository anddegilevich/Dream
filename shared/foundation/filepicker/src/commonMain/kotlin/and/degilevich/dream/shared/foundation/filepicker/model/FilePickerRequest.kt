package and.degilevich.dream.shared.foundation.filepicker.model

data class FilePickerRequest(
    val key: String,
    val isMultiselect: Boolean = false,
    val source: FilePickerSource = FilePickerSource.GALLERY,
    val mimeTypes: Set<String> = emptySet(),
)