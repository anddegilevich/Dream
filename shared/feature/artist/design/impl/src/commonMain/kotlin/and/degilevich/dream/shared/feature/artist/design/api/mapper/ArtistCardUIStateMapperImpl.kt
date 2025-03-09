package and.degilevich.dream.shared.feature.artist.design.api.mapper

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIState
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData

internal class ArtistCardUIStateMapperImpl : ArtistCardUIStateMapper {
    override fun map(
        artist: ArtistData,
        isEnabled: Boolean
    ): ArtistCardUIState {
        return with(artist) {
            ArtistCardUIState(
                id = id,
                name = name,
                iconUrl = artist.images.firstOrNull()?.url.orEmpty(),
                isEnabled = isEnabled
            )
        }
    }
}