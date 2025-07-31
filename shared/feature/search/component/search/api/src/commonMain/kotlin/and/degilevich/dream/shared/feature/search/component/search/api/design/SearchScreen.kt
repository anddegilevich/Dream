package and.degilevich.dream.shared.feature.search.component.search.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource

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
            .padding(horizontal = 16.dp)
    ) {
        Space(16.dp)
        SearchTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.query,
            placeholder = stringResource(Res.strings.hint_search)
        ) { value ->
            onIntent(SearchIntent.OnQueryChanged(value))
        }
    }
}