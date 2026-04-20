package and.degilevich.dream.shared.feature.track.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.track.TrackSimplifiedOutput
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackSimplifiedData
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.TrackSimplifiedOutputToDataMapper
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