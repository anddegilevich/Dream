package and.degilevich.dream.shared.feature.album.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.album.AlbumTracksOutput
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumTracksData
import and.degilevich.dream.shared.feature.album.model.core.api.data.mapper.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.artifact.api.mapper.TrackSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class AlbumTracksOutputToDataMapperImpl(
    private val trackSimplifiedOutputToDataMapper: TrackSimplifiedOutputToDataMapper
) : AlbumTracksOutputToDataMapper {
    override fun map(item: AlbumTracksOutput): AlbumTracksData {
        return with(item) {
            AlbumTracksData(
                items = items?.mapWith(trackSimplifiedOutputToDataMapper).orEmpty()
            )
        }
    }
}