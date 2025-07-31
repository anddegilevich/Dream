package and.degilevich.dream.shared.feature.search.design.api.model.card

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class AlbumSearchCardUIData(
    override val id: String,
    val iconUrl: String,
    val name: String,
    val artistName: String
) : SearchCardUIData {
    companion object : EmptyFactory<AlbumSearchCardUIData> {
        override fun empty(): AlbumSearchCardUIData {
            return AlbumSearchCardUIData(
                id = "",
                iconUrl = "",
                name = "",
                artistName = ""
            )
        }
    }
}
