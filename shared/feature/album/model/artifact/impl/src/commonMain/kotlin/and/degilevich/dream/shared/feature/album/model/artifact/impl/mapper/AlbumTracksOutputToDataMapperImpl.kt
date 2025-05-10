package and.degilevich.dream.shared.feature.album.model.artifact.impl.mapper

import and.degilevich.dream.shared.core.service.api.core.album.AlbumTracksOutput
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumTracksData
import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumTracksOutputToDataMapper
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