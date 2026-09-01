package and.degilevich.dream.shared.feature.track.domain.impl.paging

import and.degilevich.dream.shared.feature.track.domain.api.paging.LikedTracksPagingSource
import and.degilevich.dream.shared.feature.track.domain.api.usecase.GetSavedTracksUseCase
import and.degilevich.dream.shared.feature.track.model.core.api.data.SavedTrackData
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.foundation.abstraction.id.ext.distinctById
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.sync.Mutex

internal class LikedTracksPagingSourceImpl(
    private val getSavedTracksUseCase: GetSavedTracksUseCase
) : LikedTracksPagingSource {

    private val tracksMutable = MutableStateFlow<List<SavedTrackData>>(emptyList())
    override val tracks: StateFlow<List<SavedTrackData>> = tracksMutable.asStateFlow()

    private val isLoadingMutable = MutableStateFlow(false)
    override val isLoading: StateFlow<Boolean> = isLoadingMutable.asStateFlow()

    private val totalCountMutable = MutableStateFlow(0)
    override val totalCount: StateFlow<Int> = totalCountMutable.asStateFlow()

    private val errorChannel = Channel<Throwable>(capacity = Channel.BUFFERED)
    override val errors: Flow<Throwable> = errorChannel.receiveAsFlow()

    private val mutex = Mutex()

    private var isLastPageReached = false

    override suspend fun loadMore() {
        if (!mutex.tryLock()) return
        try {
            loadNextPage()
        } finally {
            mutex.unlock()
        }
    }

    private suspend fun loadNextPage() {
        if (isLastPageReached) return
        val params = GetSavedTracksParams(
            limit = PAGE_SIZE,
            offset = tracksMutable.value.size
        )
        isLoadingMutable.value = true
        try {
            getSavedTracksUseCase(params)
                .onSuccess(::appendPage)
                .onFailure { error -> errorChannel.send(error) }
        } finally {
            isLoadingMutable.value = false
        }
    }

    private fun appendPage(result: GetSavedTracksResult) {
        val tracks = (tracksMutable.value + result.tracks).distinctById()
        tracksMutable.value = tracks
        totalCountMutable.value = result.total
        isLastPageReached = result.tracks.count() < PAGE_SIZE || tracks.size >= result.total
    }

    internal companion object {
        const val PAGE_SIZE = 50
    }
}
