package and.degilevich.dream.shared.feature.artist.component.details.impl.store.model

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.navigation.api.args.ArtistDetailsNavArgs
import kotlinx.serialization.Serializable

@Serializable
data class ArtistDetailsState(
    val navArgs: ArtistDetailsNavArgs,
    val isLoading: Boolean,
    val artist: ArtistData,
    val topTracks: List<TrackData>,
    val albums: List<AlbumSimplifiedData>
)
