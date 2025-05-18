package and.degilevcih.dream.shared.core.filepicker.impl

import and.degilevich.dream.shared.core.filepicker.api.FilePickerManager
import and.degilevich.dream.shared.core.filepicker.api.channel.request.FilePickerRequestSendChannel
import and.degilevich.dream.shared.core.filepicker.api.channel.result.FilePickerResultReceiveChannel
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult
import kotlinx.coroutines.flow.receiveAsFlow

internal class FilePickerManagerImpl(
    private val filePickerRequestChannel: FilePickerRequestSendChannel,
    private val filePickerResultChannel: FilePickerResultReceiveChannel
) : FilePickerManager {

    override suspend fun subscribeToResult(
        onResult: (FilePickerResult) -> Unit
    ) {
        filePickerResultChannel.receiveAsFlow().collect(onResult)
    }

    override suspend fun openFilePicker(request: FilePickerRequest) {
        filePickerRequestChannel.send(request)
    }
}