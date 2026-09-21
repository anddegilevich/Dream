package and.degilevich.dream.shared.feature.search.component.search.impl.component

import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchState
import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.ui.api.mapper.SearchItemDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.model.card.SearchCardUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class SearchUIStateMapper : Mapper<SearchState, SearchUIState>, KoinComponent {

    private val searchItemDataToSearchCardUIDataMapper: SearchItemDataToSearchCardUIDataMapper by inject()

    override fun map(item: SearchState): SearchUIState = with(item) {
        SearchUIState(
            query = query,
            items = mapToItems(state = this),
            isLoadingNextPage = isLoading
        )
    }

    private fun mapToItems(state: SearchState): Skeleton<ImmutableList<SearchCardUIData>> = with(state) {
        Skeleton.from(
            isLoading = items.isEmpty() && isLoading
        ) {
            items
                .mapWith(searchItemDataToSearchCardUIDataMapper)
                .toImmutableList()
        }
    }
}
