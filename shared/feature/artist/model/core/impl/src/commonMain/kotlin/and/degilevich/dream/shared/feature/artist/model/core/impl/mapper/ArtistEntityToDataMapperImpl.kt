package and.degilevich.dream.shared.feature.artist.model.core.impl.mapper

import and.degilevich.dream.shared.core.db.api.feature.artist.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistFollowersData
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistEntityToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class ArtistEntityToDataMapperImpl : ArtistEntityToDataMapper {
    override fun map(item: ArtistEntity): ArtistData {
        return with(item) {
            ArtistData(
                id = id,
                name = name.orEmpty(),
                artistType = getEnumValueByIdOrElse(id = artistType) { ArtistType.UNKNOWN },
                popularity = popularity.orZero(),
                //FIXME: Save to the separate entities
                genres = emptyList(),
                followers = ArtistFollowersData.empty(),
                images = emptyList()
            )
        }
    }
}