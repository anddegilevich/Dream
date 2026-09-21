package and.degilevich.dream.shared.feature.base.domain.api.paging.model

data class PageData<T>(
    val items: List<T>,
    val total: Int
)
