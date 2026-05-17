package and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistSimplifiedOutput
import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse
import and.degilevich.dream.shared.foundation.abstraction.id.identifier

internal class ArtistSimplifiedOutputToDataMapperImpl : ArtistSimplifiedOutputToDataMapper {

    override fun map(item: ArtistSimplifiedOutput): ArtistSimplifiedData = with(item) {
        ArtistSimplifiedData(
            id = id?.let(::ArtistId).orEmpty(ArtistId),
            name = name.orEmpty(),
            artistType = getEnumValueByIdOrElse(id = artistType?.let(::identifier)) { ArtistType.UNKNOWN }
        )
    }
}