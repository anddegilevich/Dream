package and.degilevich.dream.shared.foundation.filepicker.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class FilePickerState internal constructor() {
    private var valueMutable: MutableState<FilePickerValue> = mutableStateOf(FilePickerValue.Closed)
    internal val value: State<FilePickerValue> = valueMutable

    fun launch(config: FilePickerConfig) {
        if (valueMutable.value is FilePickerValue.Launched) return
        valueMutable.value = FilePickerValue.Launched(
            config = config
        )
    }

    internal fun reset() {
        valueMutable.value = FilePickerValue.Closed
    }
}

@Composable
fun rememberFilePickerState(): FilePickerState {
    return remember {
        FilePickerState()
    }
}