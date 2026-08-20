package and.degilevich.dream.shared.feature.search.component.search.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchIntent
import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.component.search.impl.preview.SearchUIStatePreviewProvider
import and.degilevich.dream.shared.feature.search.component.search.impl.view.semantic.SearchScreenSemantic
import and.degilevich.dream.shared.feature.search.ui.api.preview.SearchCardUIDataPreviewProvider
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.v2.runComposeUiTest
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class SearchScreenTest {

    private val provider = SearchUIStatePreviewProvider()

    private val searchField = hasTestTag(SearchScreenSemantic.TEST_TAG_SEARCH_FIELD)
    private val itemSkeleton = hasTestTag(SearchScreenSemantic.TEST_TAG_ITEM_SKELETON)
    private val item = hasTestTag(SearchScreenSemantic.TEST_TAG_ITEM)

    @Test
    fun `render skeleton state - shows search field and item skeletons`() = runComposeUiTest {
        val intents = mutableListOf<SearchIntent>()
        setContent(
            state = provider.provideSkeleton(),
            onIntent = intents::add
        )
        onNode(searchField).assertIsDisplayed()
        onAllNodes(itemSkeleton).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render default state - shows search field and items`() = runComposeUiTest {
        val intents = mutableListOf<SearchIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(searchField).assertIsDisplayed()
        onAllNodes(item).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `replace search field text - emits OnQueryChanged with new value`() = runComposeUiTest {
        val intents = mutableListOf<SearchIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(searchField).performTextReplacement(QUERY)
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(SearchIntent.OnQueryChanged(value = QUERY))
    }

    @Test
    fun `click item - emits OnItemClicked with clicked item id`() = runComposeUiTest {
        val intents = mutableListOf<SearchIntent>()
        val cards = SearchCardUIDataPreviewProvider().provideList()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onAllNodes(item)[CLICKED_ITEM_INDEX].performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(SearchIntent.OnItemClicked(id = cards[CLICKED_ITEM_INDEX].id))
    }

    private fun ComposeUiTest.setContent(
        state: SearchUIState,
        onIntent: (SearchIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            SearchScreen(
                state = state,
                onIntent = onIntent
            )
        }
    }
}

private const val QUERY = "Beatles"
private const val CLICKED_ITEM_INDEX = 1
