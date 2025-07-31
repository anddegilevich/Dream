package and.degilevich.dream.shared.feature.search.design.api.model.card

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class ArtistSearchCardUIData(
    override val id: String,
    val iconUrl: String,
    val name: String
) : SearchCardUIData {
    companion object : EmptyFactory<ArtistSearchCardUIData> {
        override fun empty(): ArtistSearchCardUIData {
            return ArtistSearchCardUIData(
                id = "",
                iconUrl = "",
                name = ""
            )
        }
    }
}