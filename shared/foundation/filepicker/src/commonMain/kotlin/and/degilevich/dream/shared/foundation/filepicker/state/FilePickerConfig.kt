package and.degilevich.dream.shared.foundation.filepicker.state

data class FilePickerConfig(
    val key: String,
    val isMultiselect: Boolean,
    val mimeTypes: Set<String>
)