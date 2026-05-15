package and.degilevich.dream.shared.feature.artist.data.impl.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.data.api.local.mapper.ArtistDataToEntityMapper

internal class ArtistDataToEntityMapperImpl : ArtistDataToEntityMapper {

    override fun map(item: ArtistData): ArtistEntity = with(item) {
        ArtistEntity(
            id = id.value,
            name = name,
            artistType = artistType.id.value
        )
    }
}