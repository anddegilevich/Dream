package and.degilevich.dream.shared.feature.artist.design.api.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import androidx.compose.runtime.Immutable

@Immutable
data class ArtistLabelUIData(
    override val id: Identifier,
    val iconUrl: String,
    val name: String
) : Identified {
    companion object : EmptyFactory<ArtistLabelUIData> {
        override fun empty(): ArtistLabelUIData {
            return ArtistLabelUIData(
                id = Identifier.empty(),
                iconUrl = "",
                name = ""
            )
        }
    }
}