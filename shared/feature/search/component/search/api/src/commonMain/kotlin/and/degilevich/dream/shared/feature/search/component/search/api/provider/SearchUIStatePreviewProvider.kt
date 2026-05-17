package and.degilevich.dream.shared.feature.search.component.search.api.provider

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.ui.api.provider.SearchCardUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class SearchUIStatePreviewProvider : LabeledPreviewParameterProvider<SearchUIState>() {

    override val labeledValues = listOf(
        "Skeleton" to provideSkeleton(),
        "Default" to provideDefault()
    )

    fun provideSkeleton(): SearchUIState {
        return SearchUIState(
            query = "Query",
            items = Skeleton.Loading
        )
    }

    fun provideDefault(): SearchUIState {
        return SearchUIState(
            query = "Query",
            items = Skeleton.Value(SearchCardUIDataPreviewProvider().provideList())
        )
    }
}