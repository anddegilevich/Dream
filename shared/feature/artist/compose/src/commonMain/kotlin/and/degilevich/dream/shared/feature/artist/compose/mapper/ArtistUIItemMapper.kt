package and.degilevich.dream.shared.feature.artist.compose.mapper

import and.degilevich.dream.shared.feature.artist.compose.model.ArtistUIItem
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData

class ArtistUIItemMapper {
    fun map(
        artist: ArtistData,
        isEnabled: Boolean
    ): ArtistUIItem {
        return with(artist) {
            ArtistUIItem(
                id = id,
                name = name,
                isEnabled = isEnabled
            )
        }
    }
}