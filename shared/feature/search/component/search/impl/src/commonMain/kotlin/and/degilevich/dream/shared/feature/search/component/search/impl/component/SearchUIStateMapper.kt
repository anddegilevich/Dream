package and.degilevich.dream.shared.feature.search.component.search.impl.component

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.component.search.impl.store.model.SearchState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class SearchUIStateMapper : Mapper<SearchState, SearchUIState> {
    override fun map(item: SearchState): SearchUIState {
        return with(item) {
            SearchUIState(
                query = query
            )
        }
    }
}