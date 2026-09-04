package and.degilevich.dream.shared.feature.search.domain.impl.paging

import and.degilevich.dream.shared.feature.search.domain.api.paging.SearchPagingSource
import and.degilevich.dream.shared.feature.search.domain.api.paging.SearchPagingSourceFactory
import and.degilevich.dream.shared.feature.search.domain.api.usecase.SearchUseCase
import com.arkivanov.decompose.ComponentContext

internal class SearchPagingSourceFactoryImpl(
    private val searchUseCase: SearchUseCase
) : SearchPagingSourceFactory {

    override fun create(componentContext: ComponentContext): SearchPagingSource = SearchPagingSourceImpl(
        componentContext = componentContext,
        searchUseCase = searchUseCase
    )
}
