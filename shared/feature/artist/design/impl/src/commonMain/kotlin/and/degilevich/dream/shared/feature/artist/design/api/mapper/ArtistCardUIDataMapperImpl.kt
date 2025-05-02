package and.degilevich.dream.shared.feature.artist.design.api.mapper

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIData
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData

internal class ArtistCardUIDataMapperImpl : ArtistCardUIDataMapper {
    override fun map(
        artist: ArtistData,
        isEnabled: Boolean
    ): ArtistCardUIData {
        return with(artist) {
            ArtistCardUIData(
                id = id,
                name = name,
                iconUrl = artist.images.firstOrNull()?.url.orEmpty(),
                isEnabled = isEnabled
            )
        }
    }
}