package and.degilevich.dream.shared.feature.album.component.details.api.component.model

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistLabelUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.Serializable

@Serializable
data class AlbumDetailsUIState(
    val iconUrl: String,
    val name: String,
    val artists: ImmutableList<ArtistLabelUIData>,
    val type: String,
    val year: String
) {
    companion object : EmptyFactory<AlbumDetailsUIState> {
        override fun empty(): AlbumDetailsUIState {
            return AlbumDetailsUIState(
                name = "",
                iconUrl = "",
                artists = persistentListOf(),
                type = "",
                year = ""
            )
        }
    }
}