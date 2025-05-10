package and.degilevich.dream.shared.feature.artist.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.core.artist.ArtistOutput
import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistFollowersData
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistFollowersOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.image.model.artifact.api.mapper.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero
import kotlin.collections.orEmpty

internal class ArtistOutputToDataMapperImpl(
    private val artistFollowersOutputToDataMapper: ArtistFollowersOutputToDataMapper,
    private val imageObjectOutputToDataMapper: ImageObjectOutputToDataMapper
) : ArtistOutputToDataMapper {
    override fun map(item: ArtistOutput): ArtistData {
        return with(item) {
            ArtistData(
                id = id.orEmpty(),
                name = name.orEmpty(),
                artistType = getEnumValueByIdOrElse(id = type) { ArtistType.UNKNOWN },
                popularity = popularity.orZero(),
                genres = genres.orEmpty(),
                followers = followers?.mapWith(artistFollowersOutputToDataMapper).orEmpty(ArtistFollowersData),
                images = images?.mapWith(imageObjectOutputToDataMapper).orEmpty()
            )
        }
    }
}