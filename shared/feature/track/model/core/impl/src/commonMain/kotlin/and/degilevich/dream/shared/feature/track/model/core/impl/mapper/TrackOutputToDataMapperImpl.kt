package and.degilevich.dream.shared.feature.track.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.core.track.TrackOutput
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.api.mapper.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class TrackOutputToDataMapperImpl(
    private val albumOutputToDataMapper: AlbumOutputToDataMapper,
    private val artistSimplifiedOutputToDataMapper: ArtistSimplifiedOutputToDataMapper
) : TrackOutputToDataMapper {
    override fun map(item: TrackOutput): TrackData {
        return with(item) {
            TrackData(
                id = id.orEmpty(),
                name = name.orEmpty(),
                album = album?.mapWith(albumOutputToDataMapper).orEmpty(AlbumData),
                popularity = popularity.orZero(),
                trackNumber = trackNumber.orZero(),
                durationMs = durationMs.orZero(),
                artists = artists?.mapWith(artistSimplifiedOutputToDataMapper).orEmpty()
            )
        }
    }
}