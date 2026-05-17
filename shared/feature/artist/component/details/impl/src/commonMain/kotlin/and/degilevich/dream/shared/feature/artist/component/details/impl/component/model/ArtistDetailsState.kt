package and.degilevich.dream.shared.feature.artist.component.details.impl.component.model

import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.navigation.api.model.args.ArtistDetailsNavArgs
import kotlinx.serialization.Serializable

@Serializable
data class ArtistDetailsState(
    val navArgs: ArtistDetailsNavArgs,
    val isLoading: Boolean,
    val artist: ArtistData,
    val albums: List<AlbumSimplifiedData>
)
