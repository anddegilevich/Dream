package and.degilevich.dream.shared.feature.artist.compose.mapper

import and.degilevich.dream.shared.feature.artist.compose.model.ArtistUIItem
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.foundation.model.mapper.Mapper

class ArtistUIItemMapper : Mapper<ArtistData, ArtistUIItem> {
    override fun map(item: ArtistData): ArtistUIItem {
        return with(item) {
            ArtistUIItem(
                id = id,
                name = name
            )
        }
    }
}