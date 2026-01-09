package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistOutput
import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistFollowersData
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistFollowersOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.image.source.api.remote.mapper.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
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
                id = Identifier(id = id.orEmpty()),
                name = name.orEmpty(),
                artistType = getEnumValueByIdOrElse(
                    id = Identifier(id = type.orEmpty())
                ) { ArtistType.UNKNOWN },
                popularity = popularity.orZero(),
                genres = genres.orEmpty(),
                followers = followers?.mapWith(artistFollowersOutputToDataMapper).orEmpty(ArtistFollowersData),
                images = images?.mapWith(imageObjectOutputToDataMapper).orEmpty()
            )
        }
    }
}