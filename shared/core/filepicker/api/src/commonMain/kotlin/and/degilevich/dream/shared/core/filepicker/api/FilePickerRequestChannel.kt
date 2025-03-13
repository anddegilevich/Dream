package and.degilevich.dream.shared.core.filepicker.api

import and.degilevich.dream.shared.foundation.abstraction.channel.ValueChannel
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest

interface FilePickerRequestChannel : ValueChannel<FilePickerRequest>