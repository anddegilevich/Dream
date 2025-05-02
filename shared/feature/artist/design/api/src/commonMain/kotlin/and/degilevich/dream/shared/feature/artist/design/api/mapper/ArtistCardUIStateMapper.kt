package and.degilevich.dream.shared.feature.artist.design.api.mapper

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIState
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData

interface ArtistCardUIStateMapper {
    fun map(
        artist: ArtistData,
        isEnabled: Boolean
    ): ArtistCardUIState
}