package and.degilevich.dream.shared.feature.artist.component.list.api.component.model

import and.degilevich.dream.shared.feature.artist.compose.model.ArtistUIItem
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class ArtistListUIState(
    val artists: ImmutableList<ArtistUIItem> = persistentListOf()
)
