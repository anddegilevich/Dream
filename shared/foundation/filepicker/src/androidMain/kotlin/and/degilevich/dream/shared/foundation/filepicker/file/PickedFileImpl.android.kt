package and.degilevich.dream.shared.foundation.filepicker.file

import android.net.Uri

internal actual data class PickedFileImpl(
    val uri: Uri
) : PickedFile {
    override val path: String = uri.path.orEmpty()
}