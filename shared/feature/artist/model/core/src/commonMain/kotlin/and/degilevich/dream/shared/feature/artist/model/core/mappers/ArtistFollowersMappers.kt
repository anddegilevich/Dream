package and.degilevich.dream.shared.feature.artist.model.core.mappers

import and.degilevich.dream.shared.core.service.api.core.artist.ArtistFollowersOutput
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistFollowersData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

fun ArtistFollowersOutput?.mapToData(): ArtistFollowersData {
    return this?.let {
        ArtistFollowersData(
            total = total.orZero()
        )
    }.orEmpty(ArtistFollowersData)
}