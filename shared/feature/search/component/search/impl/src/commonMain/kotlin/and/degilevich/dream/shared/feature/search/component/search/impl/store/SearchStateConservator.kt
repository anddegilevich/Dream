package and.degilevich.dream.shared.feature.search.component.search.impl.store

import and.degilevich.dream.shared.feature.search.component.search.impl.store.model.SearchState
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.foundation.decompose.component.store.conservator.StoreStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class SearchStateConservator : StoreStateConservator<SearchState> {
    override val key: String = SearchState::class.className()
    override val initialState: SearchState = SearchState(
        isLoading = false,
        query = "",
        searchResult = SearchResult.empty()
    )
    override val serializer: KSerializer<SearchState> = SearchState.serializer()
}