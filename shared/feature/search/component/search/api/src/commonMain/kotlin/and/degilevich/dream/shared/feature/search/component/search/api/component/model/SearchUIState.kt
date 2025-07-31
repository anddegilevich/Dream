package and.degilevich.dream.shared.feature.search.component.search.api.component.model

import and.degilevich.dream.shared.feature.search.design.api.model.card.SearchCardUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class SearchUIState(
    val query: String,
    val items: ImmutableList<SearchCardUIData>
) {
    companion object : EmptyFactory<SearchUIState> {
        override fun empty(): SearchUIState {
            return SearchUIState(
                query = "",
                items = persistentListOf()
            )
        }
    }
}
