package and.degilevich.dream.shared.feature.artist.design.api.mapper

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIData
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData

interface ArtistDataToCardUIDataMapper {
    fun map(
        artist: ArtistData,
        isEnabled: Boolean
    ): ArtistCardUIData
}