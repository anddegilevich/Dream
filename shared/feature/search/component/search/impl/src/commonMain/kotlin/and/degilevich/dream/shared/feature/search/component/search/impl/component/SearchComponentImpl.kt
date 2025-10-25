package and.degilevich.dream.shared.feature.search.component.search.impl.component

import and.degilevich.dream.shared.feature.search.component.search.api.component.SearchComponent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchSideEffect
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchState
import and.degilevich.dream.shared.template.component.impl.BaseBinderComponent
import com.arkivanov.decompose.ComponentContext

class SearchComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    SearchUIState,
    SearchIntent,
    SearchSideEffect,
    SearchState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        SearchDomainComponent(
            componentContext = childComponentContext
        )
    },
    initialUIState = SearchUIState.empty(),
    uiStateMapper = SearchUIStateMapper()
),
    SearchComponent