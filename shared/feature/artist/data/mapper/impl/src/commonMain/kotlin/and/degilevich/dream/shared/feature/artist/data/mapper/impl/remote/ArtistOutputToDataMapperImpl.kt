package and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistOutput
import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class ArtistOutputToDataMapperImpl(
    private val imageObjectOutputToDataMapper: ImageObjectOutputToDataMapper
) : ArtistOutputToDataMapper {

    override fun map(item: ArtistOutput): ArtistData = with(item) {
        ArtistData(
            id = id?.let(::ArtistId).orEmpty(ArtistId),
            name = name.orEmpty(),
            artistType = getEnumValueByIdOrElse(id = type?.let(::identifier)) { ArtistType.UNKNOWN },
            images = images?.mapWith(imageObjectOutputToDataMapper).orEmpty()
        )
    }
}