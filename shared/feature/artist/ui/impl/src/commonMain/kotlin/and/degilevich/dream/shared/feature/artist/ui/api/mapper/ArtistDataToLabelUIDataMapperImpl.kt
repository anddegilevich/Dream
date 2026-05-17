package and.degilevich.dream.shared.feature.artist.ui.api.mapper

import and.degilevich.dream.shared.feature.artist.ui.api.model.ArtistLabelUIData
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData

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