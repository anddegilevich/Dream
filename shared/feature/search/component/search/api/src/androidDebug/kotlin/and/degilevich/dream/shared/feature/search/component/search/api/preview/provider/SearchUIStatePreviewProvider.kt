package and.degilevich.dream.shared.feature.search.component.search.api.preview.provider

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState

object SearchUIStatePreviewProvider {
    fun provide(): SearchUIState {
        return SearchUIState(
            query = ""
        )
    }
}