package and.degilevich.dream.shared.feature.track.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.TrackObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.SimplifiedAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.artifact.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.SimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.artifact.data.TrackId
import and.degilevich.dream.shared.feature.track.model.core.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class TrackOutputToDataMapperImpl(
    private val simplifiedAlbumOutputToDataMapper: SimplifiedAlbumOutputToDataMapper,
    private val simplifiedArtistOutputToDataMapper: SimplifiedArtistOutputToDataMapper
) : TrackOutputToDataMapper {

    override fun map(item: TrackObject): TrackData = with(item) {
        TrackData(
            id = id?.let(::TrackId).orEmpty(TrackId),
            name = name.orEmpty(),
            album = album?.mapWith(simplifiedAlbumOutputToDataMapper).orEmpty(SimplifiedAlbumData),
            trackNumber = trackNumber.orZero(),
            durationMs = durationMs.orZero(),
            artists = artists?.mapWith(simplifiedArtistOutputToDataMapper).orEmpty()
        )
    }
}