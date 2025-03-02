package and.degilevich.dream.shared.feature.artist.component.details.api.component.model

import and.degilevich.dream.shared.feature.artist.compose.model.ArtistUIItem
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class ArtistDetailsUIState(
    val artistIconUrl: String = "",
    val artistName: String = "",
    val similarArtists: ImmutableList<ArtistUIItem> = persistentListOf()
)
