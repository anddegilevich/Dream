package and.degilevich.dream.shared.feature.search.component.search.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class SearchUIState(
    val query: String
) {
    companion object : EmptyFactory<SearchUIState> {
        override fun empty(): SearchUIState {
            return SearchUIState(
                query = ""
            )
        }
    }
}
