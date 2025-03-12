package and.degilevich.dream.shared.foundation.filepicker.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

internal class FilePickerStateImpl : FilePickerState {

    private var valueMutable: MutableState<FilePickerValue> = mutableStateOf(FilePickerValue.Closed)
    override val value: State<FilePickerValue> = valueMutable

    override fun open(config: FilePickerConfig) {
        valueMutable.value = FilePickerValue.Displayed(
            config = config
        )
    }

    override fun close() {
        valueMutable.value = FilePickerValue.Closed
    }
}