package and.degilevich.dream.shared.core.filepicker.impl

import and.degilevich.dream.shared.core.filepicker.api.FilePickerManager
import and.degilevich.dream.shared.core.filepicker.api.channel.request.FilePickerRequestSendChannel
import and.degilevich.dream.shared.core.filepicker.api.channel.result.FilePickerResultReceiveChannel
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import kotlinx.coroutines.flow.receiveAsFlow

internal class FilePickerManagerImpl(
    filePickerResultChannel: FilePickerResultReceiveChannel,
    private val filePickerRequestChannel: FilePickerRequestSendChannel
) : FilePickerManager {

    private val filePickerResultFlow = filePickerResultChannel.receiveAsFlow()

    override suspend fun subscribeToResult(
        key: String,
        onResult: (uris: List<String>) -> Unit
    ) {
        filePickerResultFlow.collect { result ->
            if (result.key == key) {
                onResult(result.uris)
            }
        }
    }

    override suspend fun openFilePicker(request: FilePickerRequest) {
        filePickerRequestChannel.send(request)
    }
}