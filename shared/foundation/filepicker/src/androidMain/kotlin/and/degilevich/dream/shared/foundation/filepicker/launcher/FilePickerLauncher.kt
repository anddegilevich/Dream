package and.degilevich.dream.shared.foundation.filepicker.launcher

import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest

internal interface FilePickerLauncher {
    fun launch(
        request: FilePickerRequest
    )
}