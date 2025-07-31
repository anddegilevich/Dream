package and.degilevich.dream.shared.feature.search.design.impl.mapper

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.search.design.api.mapper.ArtistDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.design.api.model.card.ArtistSearchCardUIData

internal class ArtistDataToSearchCardUIDataMapperImpl : ArtistDataToSearchCardUIDataMapper {
    override fun map(item: ArtistData): ArtistSearchCardUIData {
        return with(item) {
            ArtistSearchCardUIData(
                id = id,
                iconUrl = images.firstOrNull()?.url.orEmpty(),
                name = name
            )
        }
    }
}