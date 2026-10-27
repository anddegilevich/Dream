package and.degilevich.dream.shared.feature.album.component.details.impl.component.model

import and.degilevich.dream.shared.feature.album.domain.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.artist.domain.model.core.api.data.ArtistData
import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import kotlinx.serialization.Serializable

@Serializable
data class AlbumDetailsState(
    val navArgs: AlbumDetailsNavArgs,
    val isLoading: Boolean,
    val album: AlbumData,
    val artists: List<ArtistData>
)
