package and.degilevich.dream.shared.feature.search.design.api.model.card

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import androidx.compose.runtime.Immutable

@Immutable
data class ArtistSearchCardUIData(
    override val id: Identifier,
    val iconUrl: String,
    val name: String
) : SearchCardUIData {

    companion object : EmptyFactory<ArtistSearchCardUIData> {

        override fun empty(): ArtistSearchCardUIData {
            return ArtistSearchCardUIData(
                id = Identifier.empty(),
                iconUrl = "",
                name = ""
            )
        }
    }
}