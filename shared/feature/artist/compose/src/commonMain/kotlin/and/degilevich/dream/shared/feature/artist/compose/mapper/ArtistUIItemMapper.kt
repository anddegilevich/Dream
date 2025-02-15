package and.degilevich.dream.shared.feature.artist.compose.mapper

import and.degilevich.dream.shared.feature.artist.compose.model.ArtistUIItem
import and.degilevich.dream.shared.feature.artist.model.artifact.abstraction.ArtistInfo

class ArtistUIItemMapper {
    fun map(
        artist: ArtistInfo,
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