package and.degilevich.dream.shared.feature.artist.model.core.mappers

import and.degilevich.dream.shared.core.service.api.core.artist.ArtistOutput
import and.degilevich.dream.shared.core.db.api.feature.artist.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistFollowersData
import and.degilevich.dream.shared.feature.image.model.artifact.mappers.mapToData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

fun ArtistOutput?.mapToData(): ArtistData {
    return this?.let {
        ArtistData(
            id = id.orEmpty(),
            name = name.orEmpty(),
            artistType = getEnumValueByIdOrElse(id = artistType) { ArtistType.UNKNOWN },
            popularity = popularity.orZero(),
            genres = genres.orEmpty(),
            followers = followers.mapToData(),
            images = images?.map { image ->
                image.mapToData()
            }.orEmpty()
        )
    }.orEmpty(ArtistData)
}

fun ArtistEntity.mapToData(): ArtistData {
    return ArtistData(
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

fun ArtistData.mapToEntity(): ArtistEntity {
    return ArtistEntity(
        id = id,
        name = name,
        artistType = artistType.id,
        popularity = popularity,
    )
}