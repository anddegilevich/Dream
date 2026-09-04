package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingPlaylistTrackObject
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class PlaylistTracksResponseToResultMapperImpl(
    private val playlistTrackOutputToDataMapper: PlaylistTrackOutputToDataMapper
) : PlaylistTracksResponseToResultMapper {

    override fun map(item: PagingPlaylistTrackObject): GetPlaylistTracksResult = with(item) {
        GetPlaylistTracksResult(
            tracks = items.mapWith(playlistTrackOutputToDataMapper),
            total = total
        )
    }
}
