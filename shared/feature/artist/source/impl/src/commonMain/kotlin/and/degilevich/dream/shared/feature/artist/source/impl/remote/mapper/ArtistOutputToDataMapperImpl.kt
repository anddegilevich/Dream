package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistOutput
import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.image.source.api.remote.mapper.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class ArtistOutputToDataMapperImpl(
    private val imageObjectOutputToDataMapper: ImageObjectOutputToDataMapper
) : ArtistOutputToDataMapper {

    override fun map(item: ArtistOutput): ArtistData {
        return with(item) {
            ArtistData(
                id = id?.let(::Identifier).orEmpty(Identifier),
                name = name.orEmpty(),
                artistType = getEnumValueByIdOrElse(
                    id = type?.let(::Identifier).orEmpty(Identifier)
                ) { ArtistType.UNKNOWN },
                images = images?.mapWith(imageObjectOutputToDataMapper).orEmpty()
            )
        }
    }
}