package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedIntent
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedUIState
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.preview.RecentlyPlayedUIStatePreviewProvider
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.view.semantic.RecentlyPlayedViewSemantic
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.v2.runComposeUiTest
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class RecentlyPlayedViewTest {

    private val provider = RecentlyPlayedUIStatePreviewProvider()

    private val title = hasTestTag(RecentlyPlayedViewSemantic.TEST_TAG_TITLE)
    private val itemSkeleton = hasTestTag(RecentlyPlayedViewSemantic.TEST_TAG_ITEM_SKELETON)
    private val item = hasTestTag(RecentlyPlayedViewSemantic.TEST_TAG_ITEM)

    @Test
    fun `render skeleton state - shows title and item skeletons`() = runComposeUiTest {
        val intents = mutableListOf<RecentlyPlayedIntent>()
        setContent(
            state = provider.provideSkeleton(),
            onIntent = intents::add
        )

        onNode(title).assertIsDisplayed()
        onAllNodes(itemSkeleton).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render skeleton state - shows a skeleton per grid cell`() = runComposeUiTest {
        setContent(state = provider.provideSkeleton())

        onAllNodes(itemSkeleton).assertCountEquals(EXPECTED_ITEM_COUNT)
    }

    @Test
    fun `render default state - shows title and items`() = runComposeUiTest {
        val intents = mutableListOf<RecentlyPlayedIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(title).assertIsDisplayed()
        onAllNodes(item).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render default state - shows all ten played tracks`() = runComposeUiTest {
        setContent(state = provider.provideDefault())

        onAllNodes(item).assertCountEquals(EXPECTED_ITEM_COUNT)
    }

    @Test
    fun `click track - emits OnTrackClicked with clicked track id`() = runComposeUiTest {
        val intents = mutableListOf<RecentlyPlayedIntent>()
        val items = provider.provideList()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onAllNodes(item)[CLICKED_ITEM_INDEX].performClick()

        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(
            RecentlyPlayedIntent.OnTrackClicked(id = items[CLICKED_ITEM_INDEX].id)
        )
    }

    private fun ComposeUiTest.setContent(
        state: RecentlyPlayedUIState,
        onIntent: (RecentlyPlayedIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            RecentlyPlayedView(
                state = state,
                onIntent = onIntent
            )
        }
    }
}

private const val EXPECTED_ITEM_COUNT = 10
private const val CLICKED_ITEM_INDEX = 1
