package and.degilevcih.dream.shared.core.filepicker.impl

import and.degilevich.dream.shared.core.filepicker.api.FilePickerManager
import and.degilevich.dream.shared.core.filepicker.api.FilePickerRequestChannel
import and.degilevich.dream.shared.core.filepicker.api.FilePickerResultChannel
import and.degilevich.dream.shared.foundation.dispatcher.ext.flow.flowOnBackground
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult

internal class FilePickerManagerImpl(
    private val filePickerRequestChannel: FilePickerRequestChannel,
    private val filePickerResultChannel: FilePickerResultChannel
) : FilePickerManager {

    override suspend fun subscribeToResult(
        onResult: (FilePickerResult) -> Unit
    ) {
        filePickerResultChannel.value
            .flowOnBackground()
            .collect(onResult)
    }

    override suspend fun openFilePicker(request: FilePickerRequest) {
        filePickerRequestChannel.send(request)
    }
}