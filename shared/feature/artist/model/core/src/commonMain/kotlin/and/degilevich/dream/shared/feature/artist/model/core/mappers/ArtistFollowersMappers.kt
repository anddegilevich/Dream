package and.degilevich.dream.shared.feature.artist.model.core.mappers

import and.degilevich.dream.shared.core.service.api.core.ArtistFollowersOutput
import and.degilevich.dream.shared.feature.artist.model.core.ArtistFollowersData
import and.degilevich.dream.shared.foundation.model.empty.state.ext.orEmpty
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

fun ArtistFollowersOutput?.mapToDomain(): ArtistFollowersData {
    return this?.let {
        ArtistFollowersData.Base(
            total = total.orZero()
        )
    }.orEmpty(ArtistFollowersData)
}