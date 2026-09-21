package and.degilevich.dream.shared.feature.playlist.domain.impl.paging

import and.degilevich.dream.shared.feature.base.domain.api.paging.model.PageData
import and.degilevich.dream.shared.feature.base.domain.impl.paging.BasePagingSource
import and.degilevich.dream.shared.feature.playlist.domain.api.paging.PlaylistTracksPagingSource
import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetPlaylistTracksUseCase
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistTrackData
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult
import com.arkivanov.decompose.ComponentContext

internal class PlaylistTracksPagingSourceImpl(
    componentContext: ComponentContext,
    private val getPlaylistTracksUseCase: GetPlaylistTracksUseCase
) : BasePagingSource<PlaylistTrackData>(
    componentContext = componentContext,
    pageSize = PAGE_SIZE,
    itemSerializer = PlaylistTrackData.serializer()
),
    PlaylistTracksPagingSource {

    private var playlistId: PlaylistId = PlaylistId.empty()

    override fun setPlaylistId(id: PlaylistId) {
        if (playlistId == id) return
        playlistId = id
        reset()
    }

    override suspend fun loadPage(
        limit: Int,
        offset: Int
    ): Result<PageData<PlaylistTrackData>> {
        if (playlistId.value.isEmpty()) return Result.success(EMPTY_PAGE)
        val params = GetPlaylistTracksParams(
            id = playlistId,
            limit = limit,
            offset = offset
        )
        return getPlaylistTracksUseCase(params).map(::mapResultToPage)
    }

    private fun mapResultToPage(result: GetPlaylistTracksResult): PageData<PlaylistTrackData> = PageData(
        items = result.tracks,
        total = result.total
    )

    internal companion object {
        const val PAGE_SIZE = 50
        val EMPTY_PAGE = PageData<PlaylistTrackData>(
            items = emptyList(),
            total = 0
        )
    }
}
