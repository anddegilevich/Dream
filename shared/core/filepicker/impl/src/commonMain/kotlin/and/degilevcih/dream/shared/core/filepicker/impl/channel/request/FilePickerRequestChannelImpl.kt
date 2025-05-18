package and.degilevcih.dream.shared.core.filepicker.impl.channel.request

import and.degilevich.dream.shared.core.filepicker.api.channel.request.FilePickerRequestChannel
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import kotlinx.coroutines.channels.Channel

internal class FilePickerRequestChannelImpl : FilePickerRequestChannel, Channel<FilePickerRequest> by Channel()