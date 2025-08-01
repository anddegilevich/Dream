package and.degilevich.dream.shared.feature.album.component.details.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class AlbumDetailsLayoutUIData(
    val iconUrl: String,
    val name: String,
    val type: String,
    val year: String,
) {
    companion object : EmptyFactory<AlbumDetailsLayoutUIData> {
        override fun empty(): AlbumDetailsLayoutUIData {
            return AlbumDetailsLayoutUIData(
                iconUrl = "",
                name = "",
                type = "",
                year = "",
            )
        }
    }
}