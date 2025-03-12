package and.degilevich.dream.shared.foundation.filepicker.state

sealed interface FilePickerValue {

    val key: String

    data object Closed : FilePickerValue {
        override val key: String = ""
    }

    data class Launched(
        val config: FilePickerConfig,
    ) : FilePickerValue {
        override val key: String = config.key
    }
}