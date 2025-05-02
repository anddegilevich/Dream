package and.degilevich.dream.shared.feature.artist.component.list.api.component.model

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class ArtistListUIState(
    val artistCount: String,
    val artists: ImmutableList<ArtistCardUIData>
) {
    companion object : EmptyFactory<ArtistListUIState> {
        override fun empty(): ArtistListUIState {
            return ArtistListUIState(
                artistCount = "",
                artists = persistentListOf()
            )
        }
    }
}
