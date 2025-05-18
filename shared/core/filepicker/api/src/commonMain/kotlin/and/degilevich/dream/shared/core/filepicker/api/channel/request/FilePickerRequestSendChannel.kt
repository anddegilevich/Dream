package and.degilevich.dream.shared.core.filepicker.api.channel.request

import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import kotlinx.coroutines.channels.SendChannel

interface FilePickerRequestSendChannel : SendChannel<FilePickerRequest>