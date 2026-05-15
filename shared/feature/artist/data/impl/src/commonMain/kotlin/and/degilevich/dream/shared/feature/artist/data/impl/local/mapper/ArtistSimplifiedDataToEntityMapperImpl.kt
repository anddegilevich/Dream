package and.degilevich.dream.shared.feature.artist.data.impl.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.artist.data.api.local.mapper.ArtistSimplifiedDataToEntityMapper

internal class ArtistSimplifiedDataToEntityMapperImpl : ArtistSimplifiedDataToEntityMapper {

    override fun map(item: ArtistSimplifiedData): ArtistEntity = with(item) {
        ArtistEntity(
            id = id.value,
            name = name,
            artistType = artistType.id.value
        )
    }
}