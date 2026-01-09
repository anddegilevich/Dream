package and.degilevich.dream.shared.feature.album.design.api.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import androidx.compose.runtime.Immutable

@Immutable
data class AlbumCardUIData(
    override val id: Identifier,
    val iconUrl: String,
    val name: String,
    val artists: String,
) : Identified {
    companion object : EmptyFactory<AlbumCardUIData> {
        override fun empty(): AlbumCardUIData {
            return AlbumCardUIData(
                id = Identifier(""),
                iconUrl = "",
                name = "",
                artists = ""
            )
        }
    }
}
