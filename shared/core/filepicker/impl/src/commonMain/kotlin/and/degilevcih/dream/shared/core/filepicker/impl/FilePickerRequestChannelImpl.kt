package and.degilevcih.dream.shared.core.filepicker.impl

import and.degilevich.dream.shared.core.filepicker.api.FilePickerRequestChannel
import and.degilevich.dream.shared.foundation.abstraction.channel.ValueChannelAbs
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest

internal class FilePickerRequestChannelImpl : ValueChannelAbs<FilePickerRequest>(), FilePickerRequestChannel