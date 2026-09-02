package and.degilevich.dream.shared.feature.playlist.domain.api.paging

import and.degilevich.dream.shared.feature.base.domain.api.paging.PagingSource
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistTrackData

interface PlaylistTracksPagingSource : PagingSource<PlaylistTrackData> {

    fun setPlaylistId(id: PlaylistId)
}
