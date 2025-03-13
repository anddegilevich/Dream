package and.degilevich.dream.shared.core.filepicker.api

import and.degilevich.dream.shared.foundation.abstraction.channel.ValueChannel
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult

interface FilePickerResultChannel : ValueChannel<FilePickerResult>