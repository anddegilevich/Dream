package and.degilevich.dream.shared.foundation.filepicker.state

sealed interface FilePickerValue {
    data object Closed : FilePickerValue
    data class Displayed(
        val config: FilePickerConfig
    ) : FilePickerValue
}