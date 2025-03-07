package and.degilevich.dream.shared.feature.artist.design.api.mapper

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistUIItem
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData

interface ArtistUIItemMapper {
    fun map(
        artist: ArtistData,
        isEnabled: Boolean
    ): ArtistUIItem
}