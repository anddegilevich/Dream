package and.degilevich.dream.shared.feature.artist.design.api.mapper

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistUIItem
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData

internal class ArtistUIItemMapperImpl : ArtistUIItemMapper {
    override fun map(
        artist: ArtistData,
        isEnabled: Boolean
    ): ArtistUIItem {
        return with(artist) {
            ArtistUIItem(
                id = id,
                name = name,
                iconUrl = artist.images.firstOrNull()?.url.orEmpty(),
                isEnabled = isEnabled
            )
        }
    }
}