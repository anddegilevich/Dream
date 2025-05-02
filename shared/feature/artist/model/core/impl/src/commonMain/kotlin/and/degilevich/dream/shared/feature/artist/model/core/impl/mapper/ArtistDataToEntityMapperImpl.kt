package and.degilevich.dream.shared.feature.artist.model.core.impl.mapper

import and.degilevich.dream.shared.core.db.api.feature.artist.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistDataToEntityMapper

internal class ArtistDataToEntityMapperImpl : ArtistDataToEntityMapper {
    override fun map(item: ArtistData): ArtistEntity {
        return with(item) {
            ArtistEntity(
                id = id,
                name = name,
                artistType = artistType.id,
                popularity = popularity,
            )
        }
    }
}