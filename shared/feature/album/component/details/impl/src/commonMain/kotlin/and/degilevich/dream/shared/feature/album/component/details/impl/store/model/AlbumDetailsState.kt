package and.degilevich.dream.shared.feature.album.component.details.impl.store.model

import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import kotlinx.serialization.Serializable

@Serializable
data class AlbumDetailsState(
    val navArgs: AlbumDetailsNavArgs,
    val isLoading: Boolean,
    val album: AlbumData,
    val artists: List<ArtistData>
)
