package and.degilevich.dream.shared.feature.artist.data.mapper.impl.local

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.ArtistSimplifiedDataToEntityMapper

internal class ArtistSimplifiedDataToEntityMapperImpl : ArtistSimplifiedDataToEntityMapper {

    override fun map(item: ArtistSimplifiedData): ArtistEntity = with(item) {
        ArtistEntity(
            id = id.value,
            name = name,
            artistType = artistType.id.value
        )
    }
}