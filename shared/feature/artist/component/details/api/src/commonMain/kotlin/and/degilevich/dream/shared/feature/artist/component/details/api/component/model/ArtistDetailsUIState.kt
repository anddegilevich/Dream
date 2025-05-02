package and.degilevich.dream.shared.feature.artist.component.details.api.component.model

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIState
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class ArtistDetailsUIState(
    val artistIconUrl: String,
    val artistName: String,
    val similarArtists: ImmutableList<ArtistCardUIState>
) {
    companion object : EmptyFactory<ArtistDetailsUIState> {
        override fun empty(): ArtistDetailsUIState {
            return ArtistDetailsUIState(
                artistIconUrl = "",
                artistName = "",
                similarArtists = persistentListOf()
            )
        }
    }
}
