package and.degilevich.dream.shared.feature.artist.component.details.impl.store.model

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.navigation.api.args.ArtistDetailsNavArgs
import kotlinx.serialization.Serializable

@Serializable
data class ArtistDetailsState(
    val navArgs: ArtistDetailsNavArgs,
    val isLoading: Boolean,
    val artist: ArtistData,
    val similarArtists: List<ArtistData>,
)
