package and.degilevich.dream.shared.feature.track.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedTrackObject
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.SimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SimplifiedTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.artifact.data.SimplifiedTrackData
import and.degilevich.dream.shared.feature.track.model.artifact.data.TrackId
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class SimplifiedTrackOutputToDataMapperImpl(
    private val simplifiedArtistOutputToDataMapper: SimplifiedArtistOutputToDataMapper
) : SimplifiedTrackOutputToDataMapper {

    override fun map(item: SimplifiedTrackObject): SimplifiedTrackData = with(item) {
        SimplifiedTrackData(
            id = id?.let(::TrackId).orEmpty(TrackId),
            name = name.orEmpty(),
            trackNumber = trackNumber.orZero(),
            durationMs = durationMs.orZero(),
            artists = artists?.mapWith(simplifiedArtistOutputToDataMapper).orEmpty()
        )
    }
}