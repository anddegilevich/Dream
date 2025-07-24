package and.degilevich.dream.shared.feature.artist.component.details.api.component.model

import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shated.feature.track.design.api.model.TrackCardUIData
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class ArtistDetailsUIState(
    val iconUrl: String,
    val name: String,
    val topTracks: ImmutableList<TrackCardUIData>,
    val albums: ImmutableList<AlbumCardUIData>
) {
    companion object : EmptyFactory<ArtistDetailsUIState> {
        override fun empty(): ArtistDetailsUIState {
            return ArtistDetailsUIState(
                iconUrl = "",
                name = "",
                topTracks = persistentListOf(),
                albums = persistentListOf()
            )
        }
    }
}
