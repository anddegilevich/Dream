package and.degilevich.dream.shared.feature.track.data.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.track.TrackOutput
import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.album.data.api.remote.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.artifact.data.TrackId
import and.degilevich.dream.shared.feature.track.model.core.data.TrackData
import and.degilevich.dream.shared.feature.track.data.api.remote.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class TrackOutputToDataMapperImpl(
    private val albumSimplifiedOutputToDataMapper: AlbumSimplifiedOutputToDataMapper,
    private val artistSimplifiedOutputToDataMapper: ArtistSimplifiedOutputToDataMapper
) : TrackOutputToDataMapper {

    override fun map(item: TrackOutput): TrackData = with(item) {
        TrackData(
            id = id?.let(::TrackId).orEmpty(TrackId),
            name = name.orEmpty(),
            album = album?.mapWith(albumSimplifiedOutputToDataMapper).orEmpty(AlbumSimplifiedData),
            trackNumber = trackNumber.orZero(),
            durationMs = durationMs.orZero(),
            artists = artists?.mapWith(artistSimplifiedOutputToDataMapper).orEmpty()
        )
    }
}