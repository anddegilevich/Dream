package and.degilevich.dream.shared.feature.search.component.search.api.preview.provider

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.design.api.preview.provider.SearchCardUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton

object SearchUIStatePreviewProvider {
    fun provide(): SearchUIState {
        return SearchUIState(
            query = "Query",
            items = Skeleton.Value(SearchCardUIDataPreviewProvider.provideList())
        )
    }

    fun provideSkeleton(): SearchUIState {
        return SearchUIState(
            query = "Query",
            items = Skeleton.Loading
        )
    }
}