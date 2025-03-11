package and.degilevich.dream.shared.foundation.filepicker.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

internal class FilePickerStateImpl : FilePickerState {

    private var valueMutable: FilePickerValue by mutableStateOf(FilePickerValue.Closed)
    override val value: FilePickerValue = valueMutable

    override fun open(config: FilePickerConfig) {
        valueMutable = FilePickerValue.Displayed(
            config = config
        )
    }
}