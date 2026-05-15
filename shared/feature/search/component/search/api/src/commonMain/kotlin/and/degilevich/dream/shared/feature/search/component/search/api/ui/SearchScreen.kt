package and.degilevich.dream.shared.feature.search.component.search.api.ui

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.component.search.api.ui.semantic.SearchScreenSemantic
import and.degilevich.dream.shared.feature.search.component.search.api.provider.SearchUIStatePreviewProvider
import and.degilevich.dream.shared.feature.search.ui.api.ui.SearchCard
import and.degilevich.dream.shared.feature.search.ui.api.ui.SearchTextField
import and.degilevich.dream.shared.feature.search.ui.api.ui.skeleton.SkeletonSearchCard
import and.degilevich.dream.shared.foundation.compose.draggable.OnDragLaunchedEffect
import and.degilevich.dream.shared.foundation.compose.ext.plus
import and.degilevich.dream.shared.foundation.compose.ime.controller.rememberImeController
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.identifiedSkeletonItems
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun SearchScreen(
    state: SearchUIState,
    modifier: Modifier = Modifier,
    onIntent: (SearchIntent) -> Unit
) {
    val lazyListState = rememberLazyListState()
    val imeController = rememberImeController()

    OnDragLaunchedEffect(interactionSource = lazyListState.interactionSource) {
        imeController.hide()
    }

    Column(
        modifier = modifier
            .themeBackground()
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        SearchTextField(
            modifier = Modifier
                .testTag(SearchScreenSemantic.TEST_TAG_SEARCH_FIELD)
                .padding(16.dp)
                .fillMaxWidth(),
            value = state.query,
            placeholder = stringResource(Res.strings.hint_search)
        ) { value ->
            onIntent(SearchIntent.OnQueryChanged(value))
        }
        LazyColumn(
            modifier = Modifier.weight(1f),
            state = lazyListState,
            contentPadding = PaddingValues(16.dp)
                .plus(WindowInsets.navigationBars.asPaddingValues()),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            identifiedSkeletonItems(
                skeleton = state.items,
                loadingItemsCount = 16,
                loadingItemContent = {
                    SkeletonSearchCard(
                        modifier = Modifier.testTag(SearchScreenSemantic.TEST_TAG_ITEM_SKELETON)
                    )
                },
                itemContent = { item ->
                    SearchCard(
                        modifier = Modifier
                            .testTag(SearchScreenSemantic.TEST_TAG_ITEM)
                            .animateItem()
                            .fillMaxWidth(),
                        data = item,
                        onClicked = { id ->
                            onIntent(SearchIntent.OnItemClicked(id))
                        }
                    )
                }
            )
        }
    }
}

@LightDarkPreviews
@Composable
private fun SearchScreenPreview(
    @PreviewParameter(SearchUIStatePreviewProvider::class)
    state: SearchUIState
) = ComposeAppTheme {
    SearchScreen(
        state = state
    ) { }
}