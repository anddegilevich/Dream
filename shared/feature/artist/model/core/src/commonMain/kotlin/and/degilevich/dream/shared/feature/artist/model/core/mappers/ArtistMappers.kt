package and.degilevich.dream.shared.feature.artist.model.core.mappers

import and.degilevich.dream.shared.core.service.api.core.artist.ArtistOutput
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.feature.image.model.artifact.mappers.mapToDomain
import and.degilevich.dream.shared.foundation.model.empty.state.ext.orEmpty
import and.degilevich.dream.shared.foundation.model.id.ext.getEnumValueById
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

fun ArtistOutput?.mapToDomain(): ArtistData {
    return this?.let {
        ArtistData.Base(
            id = id.orEmpty(),
            name = name.orEmpty(),
            type = getEnumValueById(type.orEmpty()) ?: ArtistType.UNKNOWN,
            popularity = popularity.orZero(),
            genres = genres.orEmpty(),
            followers = followers.mapToDomain(),
            images = images?.map { image ->
                image.mapToDomain()
            }.orEmpty()
        )
    }.orEmpty(ArtistData)
}