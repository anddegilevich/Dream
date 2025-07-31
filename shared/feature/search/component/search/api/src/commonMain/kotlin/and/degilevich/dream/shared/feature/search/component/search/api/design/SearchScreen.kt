package and.degilevich.dream.shared.feature.search.component.search.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.design.api.design.AlbumSearchCard
import and.degilevich.dream.shared.feature.search.design.api.design.ArtistSearchCard
import and.degilevich.dream.shared.feature.search.design.api.design.SearchTextField
import and.degilevich.dream.shared.feature.search.design.api.design.TrackSearchCard
import and.degilevich.dream.shared.feature.search.design.api.model.card.AlbumSearchCardUIData
import and.degilevich.dream.shared.feature.search.design.api.model.card.ArtistSearchCardUIData
import and.degilevich.dream.shared.feature.search.design.api.model.card.TrackSearchCardUIData
import and.degilevich.dream.shared.foundation.compose.ext.identifiedItems
import and.degilevich.dream.shared.foundation.compose.ext.plus
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
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
    ) {
        SearchTextField(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            value = state.query,
            placeholder = stringResource(Res.strings.hint_search)
        ) { value ->
            onIntent(SearchIntent.OnQueryChanged(value))
        }
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp)
                .plus(WindowInsets.navigationBars.asPaddingValues()),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            identifiedItems(state.items) { item ->
                when (item) {
                    is AlbumSearchCardUIData -> {
                        AlbumSearchCard(
                            modifier = Modifier.fillMaxWidth(),
                            data = item,
                            onClicked = { id ->
                                onIntent(SearchIntent.OnItemClicked(id))
                            }
                        )
                    }

                    is ArtistSearchCardUIData -> {
                        ArtistSearchCard(
                            modifier = Modifier.fillMaxWidth(),
                            data = item,
                            onClicked = { id ->
                                onIntent(SearchIntent.OnItemClicked(id))
                            }
                        )
                    }

                    is TrackSearchCardUIData -> {
                        TrackSearchCard(
                            modifier = Modifier.fillMaxWidth(),
                            data = item,
                            onClicked = { id ->
                                onIntent(SearchIntent.OnItemClicked(id))
                            }
                        )
                    }
                }
            }
        }
    }
}