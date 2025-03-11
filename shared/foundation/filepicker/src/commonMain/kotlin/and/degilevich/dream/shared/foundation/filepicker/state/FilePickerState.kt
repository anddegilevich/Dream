package and.degilevich.dream.shared.foundation.filepicker.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

interface FilePickerState {
    val value: FilePickerValue

    fun open(config: FilePickerConfig)
}

@Composable
fun rememberFilePickerState(): FilePickerState {
    return remember {
        FilePickerStateImpl()
    }
}