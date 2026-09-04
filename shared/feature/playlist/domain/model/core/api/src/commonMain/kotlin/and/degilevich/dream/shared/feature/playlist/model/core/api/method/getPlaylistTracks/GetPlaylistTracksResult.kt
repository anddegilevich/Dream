package and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks

import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistTrackData

data class GetPlaylistTracksResult(
    val tracks: List<PlaylistTrackData>,
    val total: Int
)
