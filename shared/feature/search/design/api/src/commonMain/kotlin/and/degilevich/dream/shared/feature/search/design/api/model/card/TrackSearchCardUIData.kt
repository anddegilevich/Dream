package and.degilevich.dream.shared.feature.search.design.api.model.card

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import androidx.compose.runtime.Immutable

@Immutable
data class TrackSearchCardUIData(
    override val id: Identifier,
    val iconUrl: String,
    val name: String,
    val artistName: String
) : SearchCardUIData {

    companion object : EmptyFactory<TrackSearchCardUIData> {

        override fun empty(): TrackSearchCardUIData {
            return TrackSearchCardUIData(
                id = Identifier.empty(),
                iconUrl = "",
                name = "",
                artistName = ""
            )
        }
    }
}