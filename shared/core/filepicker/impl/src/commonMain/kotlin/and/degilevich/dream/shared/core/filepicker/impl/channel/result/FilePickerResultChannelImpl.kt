package and.degilevich.dream.shared.core.filepicker.impl.channel.result

import and.degilevich.dream.shared.core.filepicker.api.channel.result.FilePickerResultChannel
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult
import kotlinx.coroutines.channels.Channel

internal class FilePickerResultChannelImpl : FilePickerResultChannel, Channel<FilePickerResult> by Channel()