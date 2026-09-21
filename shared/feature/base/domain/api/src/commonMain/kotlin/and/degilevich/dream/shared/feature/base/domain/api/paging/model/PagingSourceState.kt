package and.degilevich.dream.shared.feature.base.domain.api.paging.model

import kotlinx.serialization.Serializable

@Serializable
data class PagingSourceState<T>(
    val data: List<T>,
    val offset: Int,
    val totalCount: Int,
    val isLastPageReached: Boolean
)
