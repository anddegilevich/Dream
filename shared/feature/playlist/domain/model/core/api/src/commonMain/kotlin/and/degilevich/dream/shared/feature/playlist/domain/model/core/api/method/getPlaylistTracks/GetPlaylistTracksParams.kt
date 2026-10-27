package and.degilevich.dream.shared.feature.playlist.domain.model.core.api.method.getPlaylistTracks

import and.degilevich.dream.shared.feature.playlist.domain.model.artifact.api.data.PlaylistId

data class GetPlaylistTracksParams(
    val id: PlaylistId,
    val limit: Int,
    val offset: Int
)
