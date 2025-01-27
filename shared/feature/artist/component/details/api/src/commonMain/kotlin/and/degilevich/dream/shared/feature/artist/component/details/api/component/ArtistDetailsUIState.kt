package and.degilevich.dream.shared.feature.artist.component.details.api.component

import and.degilevich.dream.shared.feature.artist.compose.model.ArtistUIItem
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class ArtistDetailsUIState(
    val artistName: String,
    val similarArtists: ImmutableList<ArtistUIItem>
)
