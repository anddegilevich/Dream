package and.degilevcih.dream.shared.core.filepicker.impl

import and.degilevich.dream.shared.core.filepicker.api.FilePickerResultChannel
import and.degilevich.dream.shared.foundation.abstraction.channel.ValueChannelAbs
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult

internal class FilePickerResultChannelImpl : ValueChannelAbs<FilePickerResult>(), FilePickerResultChannel