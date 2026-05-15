package and.degilevich.dream.shared.feature.album.data.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.album.AlbumTracksOutput
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumTracksData
import and.degilevich.dream.shared.feature.album.data.api.remote.mapper.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.api.remote.mapper.TrackSimplifiedOutputToDataMapper
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