package and.degilevich.dream.shared.feature.track.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.model.data.track.TrackSimplifiedOutput
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.artifact.data.TrackId
import and.degilevich.dream.shared.feature.track.model.artifact.data.TrackSimplifiedData
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class TrackSimplifiedOutputToDataMapperImpl(
    private val artistSimplifiedOutputToDataMapper: ArtistSimplifiedOutputToDataMapper
) : TrackSimplifiedOutputToDataMapper {

    override fun map(item: TrackSimplifiedOutput): TrackSimplifiedData = with(item) {
        TrackSimplifiedData(
            id = id?.let(::TrackId).orEmpty(TrackId),
            name = name.orEmpty(),
            trackNumber = trackNumber.orZero(),
            durationMs = durationMs.orZero(),
            artists = artists?.mapWith(artistSimplifiedOutputToDataMapper).orEmpty()
        )
    }
}