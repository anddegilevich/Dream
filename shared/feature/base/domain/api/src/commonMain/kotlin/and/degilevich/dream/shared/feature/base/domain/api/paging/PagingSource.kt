package and.degilevich.dream.shared.feature.base.domain.api.paging

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface PagingSource<T> {

    val data: StateFlow<List<T>>
    val isLoading: StateFlow<Boolean>
    val totalCount: StateFlow<Int>
    val errors: Flow<Throwable>

    suspend fun loadFirstPage()

    suspend fun loadNextPage()

    fun reset()
}
