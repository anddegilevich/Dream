package and.degilevich.dream.shared.feature.track.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.track.TrackOutput
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class TrackOutputToDataMapperImpl(
    private val albumSimplifiedOutputToDataMapper: AlbumSimplifiedOutputToDataMapper,
    private val artistSimplifiedOutputToDataMapper: ArtistSimplifiedOutputToDataMapper
) : TrackOutputToDataMapper {

    override fun map(item: TrackOutput): TrackData {
        return with(item) {
            TrackData(
                id = Identifier(id = id.orEmpty()),
                name = name.orEmpty(),
                album = album?.mapWith(albumSimplifiedOutputToDataMapper).orEmpty(AlbumSimplifiedData),
                popularity = popularity.orZero(),
                trackNumber = trackNumber.orZero(),
                durationMs = durationMs.orZero(),
                artists = artists?.mapWith(artistSimplifiedOutputToDataMapper).orEmpty()
            )
        }
    }
}