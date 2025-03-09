package and.degilevich.dream.shared.feature.artist.component.list.api.component.model

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIState
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class ArtistListUIState(
    val artistCount: String = "",
    val artists: ImmutableList<ArtistCardUIState> = persistentListOf()
)
