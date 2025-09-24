package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistSimplifiedOutput
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse

internal class ArtistSimplifiedOutputToDataMapperImpl : ArtistSimplifiedOutputToDataMapper {
    override fun map(item: ArtistSimplifiedOutput): ArtistSimplifiedData {
        return with(item) {
            ArtistSimplifiedData(
                id = id.orEmpty(),
                name = name.orEmpty(),
                artistType = getEnumValueByIdOrElse(artistType) { ArtistType.UNKNOWN }
            )
        }
    }
}