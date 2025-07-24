package and.degilevich.dream.shared.feature.artist.component.details.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class ArtistDetailsUIState(
    val iconUrl: String,
    val name: String
) {
    companion object : EmptyFactory<ArtistDetailsUIState> {
        override fun empty(): ArtistDetailsUIState {
            return ArtistDetailsUIState(
                iconUrl = "",
                name = ""
            )
        }
    }
}
