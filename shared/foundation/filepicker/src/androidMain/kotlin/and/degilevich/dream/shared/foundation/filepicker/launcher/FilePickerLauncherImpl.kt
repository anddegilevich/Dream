package and.degilevich.dream.shared.foundation.filepicker.launcher

import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerSource
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

internal class FilePickerLauncherImpl(
    private val singleFilePickerLauncher: ActivityResultLauncher<Array<String>>,
    private val multipleFilePickerLauncher: ActivityResultLauncher<Array<String>>,
    private val singleImagePickerLauncher: ActivityResultLauncher<PickVisualMediaRequest>,
    private val multipleImagePickerLauncher: ActivityResultLauncher<PickVisualMediaRequest>,
) : FilePickerLauncher {

    override fun launch(
        request: FilePickerRequest
    ) {
        val source = request.source
        val isMultiselect = request.isMultiselect
        val mimeTypes = request.mimeTypes.toTypedArray()
        when {
            source == FilePickerSource.FILES && !isMultiselect -> {
                singleFilePickerLauncher.launch(mimeTypes)
            }

            source == FilePickerSource.FILES && isMultiselect -> {
                multipleFilePickerLauncher.launch(mimeTypes)
            }

            source == FilePickerSource.GALLERY && !isMultiselect -> {
                singleImagePickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }

            else -> {
                multipleImagePickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }
        }
    }
}