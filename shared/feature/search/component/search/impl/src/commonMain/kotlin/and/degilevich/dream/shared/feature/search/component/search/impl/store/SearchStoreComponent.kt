package and.degilevich.dream.shared.feature.search.component.search.impl.store

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchSideEffect
import and.degilevich.dream.shared.feature.search.component.search.impl.store.model.SearchState
import and.degilevich.dream.shared.template.component.impl.BaseStoreComponent
import com.arkivanov.decompose.ComponentContext

internal class SearchStoreComponent(
    componentContext: ComponentContext
) : BaseStoreComponent<
    SearchState,
    SearchIntent,
    SearchSideEffect
    >(
    componentContext = componentContext,
    storeFactory = SearchStoreFactory(),
    stateConservator = SearchStateConservator()
)