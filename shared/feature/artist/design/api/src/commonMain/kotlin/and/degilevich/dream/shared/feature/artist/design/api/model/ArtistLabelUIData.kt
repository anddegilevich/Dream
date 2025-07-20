package and.degilevich.dream.shared.feature.artist.design.api.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import androidx.compose.runtime.Immutable

@Immutable
data class ArtistLabelUIData(
    override val id: String,
    val iconUrl: String,
    val name: String
) : Identified {
    companion object : EmptyFactory<ArtistLabelUIData> {
        override fun empty(): ArtistLabelUIData {
            return ArtistLabelUIData(
                id = "",
                iconUrl = "",
                name = ""
            )
        }
    }
}