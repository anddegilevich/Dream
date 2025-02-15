package and.degilevich.dream.shared.feature.artist.model.core.mappers

import and.degilevich.dream.shared.core.service.api.core.artist.ArtistOutput
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.image.model.artifact.mappers.mapToData
import and.degilevich.dream.shared.foundation.model.empty.state.ext.orEmpty
import and.degilevich.dream.shared.foundation.model.id.ext.getEnumValueById
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

fun ArtistOutput?.mapToData(): ArtistData {
    return this?.let {
        ArtistData(
            id = id.orEmpty(),
            name = name.orEmpty(),
            artistType = getEnumValueById(type.orEmpty()) ?: ArtistType.UNKNOWN,
            popularity = popularity.orZero(),
            genres = genres.orEmpty(),
            followers = followers.mapToData(),
            images = images?.map { image ->
                image.mapToData()
            }.orEmpty()
        )
    }.orEmpty(ArtistData)
}