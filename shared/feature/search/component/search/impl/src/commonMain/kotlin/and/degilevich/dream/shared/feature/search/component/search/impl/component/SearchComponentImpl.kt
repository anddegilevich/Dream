package and.degilevich.dream.shared.feature.search.component.search.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.feature.search.component.search.api.component.SearchComponent
import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchSideEffect
import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchState
import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.component.search.impl.view.SearchScreen
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class SearchComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    SearchUIState,
    SearchIntent,
    SearchSideEffect,
    SearchState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        SearchDomainComponent(componentContext = childComponentContext)
    },
    initialUIState = SearchUIState.empty(),
    uiStateMapper = SearchUIStateMapper()
),
    SearchComponent {

    @Composable
    override fun Render() {
        SearchScreen(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}