package and.degilevich.dream.shared.feature.artist.data.mapper.impl.local

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.ArtistDataToEntityMapper

internal class ArtistDataToEntityMapperImpl : ArtistDataToEntityMapper {

    override fun map(item: ArtistData): ArtistEntity = with(item) {
        ArtistEntity(
            id = id.value,
            name = name,
            artistType = artistType.id.value
        )
    }
}