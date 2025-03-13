package and.degilevich.dream.shared.foundation.filepicker.state

import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@Stable
class FilePickerState internal constructor() {
    private var valueMutable: MutableState<FilePickerValue> = mutableStateOf(FilePickerValue.Closed)
    internal val value: State<FilePickerValue> = valueMutable

    private val mutex = Mutex()

    suspend fun launch(request: FilePickerRequest) {
        mutex.withLock {
            if (valueMutable.value is FilePickerValue.Launched) return
            valueMutable.value = FilePickerValue.Launched(
                request = request
            )
        }
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