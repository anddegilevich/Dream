package and.degilevich.dream.shared.foundation.filepicker.file

import android.net.Uri

internal actual data class PickedFileImpl(
    override val key: String,
    val androidUri: Uri
) : PickedFile {
    override val uri: String = androidUri.toString()
}