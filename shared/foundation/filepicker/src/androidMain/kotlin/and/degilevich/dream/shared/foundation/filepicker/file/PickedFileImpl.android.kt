package and.degilevich.dream.shared.foundation.filepicker.file

import android.net.Uri

internal actual data class PickedFileImpl(
    override val key: String,
    val uri: Uri
) : PickedFile {
    override val url: String = uri.toString()
}