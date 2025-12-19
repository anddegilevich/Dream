package and.degilevich.dream.shared.feature.search.component.search.api.preview.provider

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.design.api.preview.provider.SearchCardUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class SearchUIStatePreviewProvider : PreviewParameterProvider<SearchUIState> {

    override val values: Sequence<SearchUIState> = sequenceOf(
        provideSkeleton(),
        provide()
    )

    fun provideSkeleton(): SearchUIState {
        return SearchUIState(
            query = "Query",
            items = Skeleton.Loading
        )
    }

    fun provide(): SearchUIState {
        return SearchUIState(
            query = "Query",
            items = Skeleton.Value(SearchCardUIDataPreviewProvider().provideList())
        )
    }
}