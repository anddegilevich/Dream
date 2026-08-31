package and.degilevich.dream.shared.feature.track.domain.api.paging

import and.degilevich.dream.shared.feature.track.model.core.api.data.SavedTrackData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface LikedTracksPagingSource {

    val tracks: StateFlow<List<SavedTrackData>>
    val isLoading: StateFlow<Boolean>
    val totalCount: StateFlow<Int>
    val errors: Flow<Throwable>

    suspend fun loadMore()
}
