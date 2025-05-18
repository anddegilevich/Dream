package and.degilevich.dream.shared.core.filepicker.api.channel.result

import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult
import kotlinx.coroutines.channels.SendChannel

interface FilePickerResultSendChannel : SendChannel<FilePickerResult>