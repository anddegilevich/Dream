package and.degilevich.dream.shared.feature.base.domain.api.paging

import com.arkivanov.decompose.ComponentContext

interface PagingSourceFactory<S : PagingSource<*>> {

    fun create(componentContext: ComponentContext): S
}
