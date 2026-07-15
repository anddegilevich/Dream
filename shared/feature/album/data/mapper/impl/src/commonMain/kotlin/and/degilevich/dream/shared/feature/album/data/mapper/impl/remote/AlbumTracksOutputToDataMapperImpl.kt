package and.degilevich.dream.shared.feature.album.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSimplifiedTrackObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumTracksData
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SimplifiedTrackOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class AlbumTracksOutputToDataMapperImpl(
    private val simplifiedTrackOutputToDataMapper: SimplifiedTrackOutputToDataMapper
) : AlbumTracksOutputToDataMapper {

    override fun map(item: PagingSimplifiedTrackObject): AlbumTracksData = with(item) {
        AlbumTracksData(
            items = items.mapWith(simplifiedTrackOutputToDataMapper)
        )
    }
}