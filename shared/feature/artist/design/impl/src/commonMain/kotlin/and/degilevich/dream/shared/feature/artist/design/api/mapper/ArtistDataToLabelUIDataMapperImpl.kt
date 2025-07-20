package and.degilevich.dream.shared.feature.artist.design.api.mapper

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistLabelUIData
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData

internal class ArtistDataToLabelUIDataMapperImpl : ArtistDataToLabelUIDataMapper {
    override fun map(item: ArtistData): ArtistLabelUIData {
        return with(item) {
            ArtistLabelUIData(
                id = id,
                name = name,
                iconUrl = images.firstOrNull()?.url.orEmpty()
            )
        }
    }
}