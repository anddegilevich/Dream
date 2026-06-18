package and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedArtistObject
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.SimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.artifact.data.SimplifiedArtistData
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse
import and.degilevich.dream.shared.foundation.abstraction.id.identifier

internal class SimplifiedArtistOutputToDataMapperImpl : SimplifiedArtistOutputToDataMapper {

    override fun map(item: SimplifiedArtistObject): SimplifiedArtistData = with(item) {
        SimplifiedArtistData(
            id = id?.let(::ArtistId).orEmpty(ArtistId),
            name = name.orEmpty(),
            artistType = getEnumValueByIdOrElse(id = type?.value?.let(::identifier)) { ArtistType.UNKNOWN }
        )
    }
}