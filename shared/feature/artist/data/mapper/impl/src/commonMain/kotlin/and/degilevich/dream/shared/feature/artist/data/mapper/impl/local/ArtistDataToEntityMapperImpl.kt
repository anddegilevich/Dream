package and.degilevich.dream.shared.feature.artist.data.mapper.impl.local

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.ArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData

internal class ArtistDataToEntityMapperImpl : ArtistDataToEntityMapper {

    override fun map(item: ArtistData): ArtistEntity = with(item) {
        ArtistEntity(
            id = id.value,
            name = name,
            artistType = artistType.id.value
        )
    }
}