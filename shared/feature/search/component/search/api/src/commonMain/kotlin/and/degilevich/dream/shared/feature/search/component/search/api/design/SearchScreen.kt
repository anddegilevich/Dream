package and.degilevich.dream.shared.feature.search.component.search.api.design

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchScreen(
    state: SearchUIState,
    modifier: Modifier = Modifier,
    onIntent: (SearchIntent) -> Unit
) {
    Column(
        modifier = modifier
            .themeBackground()
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.query,
            onValueChange = { value ->
                onIntent(SearchIntent.OnQueryChanged(value))
            }
        )
    }
}