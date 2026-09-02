package and.degilevich.dream.shared.feature.track.domain.impl.paging

import and.degilevich.dream.shared.feature.base.domain.api.paging.model.PageData
import and.degilevich.dream.shared.feature.base.domain.impl.paging.BasePagingSource
import and.degilevich.dream.shared.feature.track.domain.api.paging.LikedTracksPagingSource
import and.degilevich.dream.shared.feature.track.domain.api.usecase.GetSavedTracksUseCase
import and.degilevich.dream.shared.feature.track.model.core.api.data.SavedTrackData
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import com.arkivanov.decompose.ComponentContext

internal class LikedTracksPagingSourceImpl(
    componentContext: ComponentContext,
    private val getSavedTracksUseCase: GetSavedTracksUseCase
) : BasePagingSource<SavedTrackData>(
    componentContext = componentContext,
    pageSize = PAGE_SIZE,
    itemSerializer = SavedTrackData.serializer()
),
    LikedTracksPagingSource {

    override suspend fun loadPage(
        limit: Int,
        offset: Int
    ): Result<PageData<SavedTrackData>> {
        val params = GetSavedTracksParams(
            limit = limit,
            offset = offset
        )
        return getSavedTracksUseCase(params).map(::mapResultToPage)
    }

    private fun mapResultToPage(result: GetSavedTracksResult): PageData<SavedTrackData> = PageData(
        items = result.tracks,
        total = result.total
    )

    internal companion object {
        const val PAGE_SIZE = 50
    }
}
