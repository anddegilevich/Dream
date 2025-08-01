package and.degilevich.dream.shared.feature.track.model.artifact.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.data.track.TrackSimplifiedOutput
import and.degilevich.dream.shared.feature.artist.model.artifact.api.mapper.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackSimplifiedData
import and.degilevich.dream.shared.feature.track.model.artifact.api.mapper.TrackSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class TrackSimplifiedOutputToDataMapperImpl(
    private val artistSimplifiedOutputToDataMapper: ArtistSimplifiedOutputToDataMapper
) : TrackSimplifiedOutputToDataMapper {
    override fun map(item: TrackSimplifiedOutput): TrackSimplifiedData {
        return with(item) {
            TrackSimplifiedData(
                id = id.orEmpty(),
                name = name.orEmpty(),
                trackNumber = trackNumber.orZero(),
                durationMs = durationMs.orZero(),
                artists = artists?.mapWith(artistSimplifiedOutputToDataMapper).orEmpty()
            )
        }
    }
}