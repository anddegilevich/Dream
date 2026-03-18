package and.degilevich.dream.shared.feature.search.component.search.api.component

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchSideEffect
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.component.search.api.design.SearchScreen
import and.degilevich.dream.shared.foundation.decompose.component.render.RenderMVIComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface SearchComponent : RenderMVIComponent<SearchUIState, SearchIntent, SearchSideEffect> {

    @Composable
    override fun Render() {
        SearchScreen(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}