package and.degilevich.dream.shared.feature.search.component.search.impl.component

import and.degilevich.dream.shared.feature.search.component.search.api.component.SearchComponent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchSideEffect
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.component.search.impl.store.SearchStoreComponent
import and.degilevich.dream.shared.feature.search.component.search.impl.store.model.SearchState
import and.degilevich.dream.shared.template.component.impl.BaseUIStoreComponent
import com.arkivanov.decompose.ComponentContext

class SearchComponentImpl(
    componentContext: ComponentContext
) : BaseUIStoreComponent<
    SearchUIState,
    SearchIntent,
    SearchSideEffect,
    SearchState,
    >(
    componentContext = componentContext,
    storeComponentFactory = { childComponentContext ->
        SearchStoreComponent(
            componentContext = childComponentContext
        )
    },
    initialUIState = SearchUIState.empty(),
    uiStateMapper = SearchUIStateMapper()
),
    SearchComponent