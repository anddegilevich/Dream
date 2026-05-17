package and.degilevich.dream.shared.feature.album.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.model.data.album.AlbumTracksOutput
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumTracksData
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class AlbumTracksOutputToDataMapperImpl(
    private val trackSimplifiedOutputToDataMapper: TrackSimplifiedOutputToDataMapper
) : AlbumTracksOutputToDataMapper {

    override fun map(item: AlbumTracksOutput): AlbumTracksData = with(item) {
        AlbumTracksData(
            items = items?.mapWith(trackSimplifiedOutputToDataMapper).orEmpty()
        )
    }
}