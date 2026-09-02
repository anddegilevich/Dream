package and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks

import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId

data class GetPlaylistTracksParams(
    val id: PlaylistId,
    val limit: Int,
    val offset: Int
)
