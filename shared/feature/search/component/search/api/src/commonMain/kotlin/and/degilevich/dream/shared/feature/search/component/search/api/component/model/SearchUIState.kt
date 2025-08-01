package and.degilevich.dream.shared.feature.search.component.search.api.component.model

import and.degilevich.dream.shared.feature.search.design.api.model.card.SearchCardUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class SearchUIState(
    val query: String,
    val items: Skeleton<ImmutableList<SearchCardUIData>>
) {
    companion object : EmptyFactory<SearchUIState> {
        override fun empty(): SearchUIState {
            return SearchUIState(
                query = "",
                items = Skeleton.Loading
            )
        }
    }
}
