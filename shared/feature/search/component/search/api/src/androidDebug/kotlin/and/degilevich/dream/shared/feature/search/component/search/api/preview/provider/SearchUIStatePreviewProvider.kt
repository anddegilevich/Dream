package and.degilevich.dream.shared.feature.search.component.search.api.preview.provider

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.design.api.preview.provider.SearchCardUIDataPreviewProvider

object SearchUIStatePreviewProvider {
    fun provide(): SearchUIState {
        return SearchUIState(
            query = "Query",
            items = SearchCardUIDataPreviewProvider.provideList()
        )
    }
}