package and.degilevich.dream.shared.feature.playlist.data.impl.remote

import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistResult
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult

internal interface PlaylistRemoteDataSource {
    suspend fun getCurrentUserPlaylists(params: GetCurrentUserPlaylistsParams): Result<GetCurrentUserPlaylistsResult>
    suspend fun getPlaylist(params: GetPlaylistParams): Result<GetPlaylistResult>
    suspend fun getPlaylistTracks(params: GetPlaylistTracksParams): Result<GetPlaylistTracksResult>
}
