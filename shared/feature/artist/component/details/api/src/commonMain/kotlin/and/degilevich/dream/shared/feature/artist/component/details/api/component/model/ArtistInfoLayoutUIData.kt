package and.degilevich.dream.shared.feature.artist.component.details.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class ArtistInfoLayoutUIData(
    val iconUrl: String,
    val name: String,
) {
    companion object Companion : EmptyFactory<ArtistInfoLayoutUIData> {
        override fun empty(): ArtistInfoLayoutUIData {
            return ArtistInfoLayoutUIData(
                iconUrl = "",
                name = ""
            )
        }
    }
}