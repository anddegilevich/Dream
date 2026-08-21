package and.degilevich.dream.shared.feature.search.component.search.impl.component

import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchState
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class SearchStateConservator : ComponentStateConservator<SearchState> {
    override val key: String = SearchState::class.className()
    override val initialState: SearchState = SearchState(
        isLoading = false,
        query = "",
        searchResult = SearchResult.empty()
    )
    override val serializer: KSerializer<SearchState> = SearchState.serializer()
}