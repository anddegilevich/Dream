package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistFollowersOutput
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistFollowersData
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistFollowersOutputToDataMapper
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class ArtistFollowersOutputToDataMapperImpl : ArtistFollowersOutputToDataMapper {
    override fun map(item: ArtistFollowersOutput): ArtistFollowersData {
        return with(item) {
            ArtistFollowersData(
                total = total.orZero()
            )
        }
    }
}