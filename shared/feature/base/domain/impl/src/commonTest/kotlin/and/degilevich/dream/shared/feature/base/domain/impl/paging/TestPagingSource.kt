package and.degilevich.dream.shared.feature.base.domain.impl.paging

import and.degilevich.dream.shared.feature.base.domain.api.paging.model.PageData
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

internal class TestPagingSource(
    componentContext: ComponentContext = DefaultComponentContext(lifecycle = LifecycleRegistry()),
    pageSize: Int = PAGE_SIZE,
    private val onLoadPage: suspend (limit: Int, offset: Int) -> Result<PageData<TestItem>>
) : BasePagingSource<TestItem>(
    componentContext = componentContext,
    pageSize = pageSize,
    itemSerializer = TestItem.serializer()
) {

    override suspend fun loadPage(
        limit: Int,
        offset: Int
    ): Result<PageData<TestItem>> = onLoadPage(limit, offset)

    internal companion object {
        const val PAGE_SIZE = 10
    }
}
