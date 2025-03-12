package and.degilevich.dream.shared.foundation.filepicker.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember

interface FilePickerState {
    val value: State<FilePickerValue>

    fun open(config: FilePickerConfig)
    fun close()
}

@Composable
fun rememberFilePickerState(): FilePickerState {
    return remember {
        FilePickerStateImpl()
    }
}