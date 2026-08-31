package and.degilevich.dream.shared.feature.track.component.liked.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksIntent
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksUIState
import and.degilevich.dream.shared.feature.track.component.liked.impl.preview.LikedTracksUIStatePreviewProvider
import and.degilevich.dream.shared.feature.track.component.liked.impl.view.semantic.LikedTracksScreenSemantic
import and.degilevich.dream.shated.feature.track.ui.api.preview.TrackCardUIDataPreviewProvider
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.v2.runComposeUiTest
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class LikedTracksScreenTest {

    private val provider = LikedTracksUIStatePreviewProvider()

    private val back = hasTestTag(LikedTracksScreenSemantic.TEST_TAG_BACK)
    private val title = hasTestTag(LikedTracksScreenSemantic.TEST_TAG_TITLE)
    private val count = hasTestTag(LikedTracksScreenSemantic.TEST_TAG_COUNT)
    private val countSkeleton = hasTestTag(LikedTracksScreenSemantic.TEST_TAG_COUNT_SKELETON)
    private val item = hasTestTag(LikedTracksScreenSemantic.TEST_TAG_ITEM)
    private val itemSkeleton = hasTestTag(LikedTracksScreenSemantic.TEST_TAG_ITEM_SKELETON)
    private val nextPageSkeleton = hasTestTag(LikedTracksScreenSemantic.TEST_TAG_NEXT_PAGE_SKELETON)

    @Test
    fun `render skeleton state - shows title count skeleton and item skeletons`() = runComposeUiTest {
        val intents = mutableListOf<LikedTracksIntent>()
        setContent(
            state = provider.provideSkeleton(),
            onIntent = intents::add
        )

        onNode(title).assertIsDisplayed()
        onNode(countSkeleton).assertIsDisplayed()
        onAllNodes(itemSkeleton).onFirst().assertIsDisplayed()
    }

    @Test
    fun `render default state - shows title count and items`() = runComposeUiTest {
        val intents = mutableListOf<LikedTracksIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(title).assertIsDisplayed()
        onNode(count).assertIsDisplayed()
        onAllNodes(item).onFirst().assertIsDisplayed()
    }

    @Test
    fun `render loading next page state - shows items and next page skeleton`() = runComposeUiTest {
        val intents = mutableListOf<LikedTracksIntent>()
        setContent(
            state = provider.provideLoadingNextPage(),
            onIntent = intents::add
        )

        onAllNodes(item).onFirst().assertIsDisplayed()
        onAllNodes(nextPageSkeleton).onFirst().assertIsDisplayed()
    }

    @Test
    fun `click back - emits OnBackClicked`() = runComposeUiTest {
        val intents = mutableListOf<LikedTracksIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(back).performClick()

        waitUntil(conditionDescription = "intent emitted") {
            intents.contains(LikedTracksIntent.OnBackClicked)
        }
    }

    @Test
    fun `click track - emits OnTrackClicked with clicked track id`() = runComposeUiTest {
        val intents = mutableListOf<LikedTracksIntent>()
        val tracks = TrackCardUIDataPreviewProvider().provideList()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onAllNodes(item)[CLICKED_ITEM_INDEX].performClick()

        waitUntil(conditionDescription = "intent emitted") {
            intents.any { intent -> intent is LikedTracksIntent.OnTrackClicked }
        }
        intents.filterIsInstance<LikedTracksIntent.OnTrackClicked>()
            .shouldContainExactly(
                LikedTracksIntent.OnTrackClicked(id = tracks[CLICKED_ITEM_INDEX].id)
            )
    }

    @Test
    fun `render short list - requests the next page once the end is reached`() = runComposeUiTest {
        val intents = mutableListOf<LikedTracksIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        waitUntil(conditionDescription = "next page requested") {
            intents.contains(LikedTracksIntent.OnNextPageRequested)
        }
        intents.shouldContainExactly(LikedTracksIntent.OnNextPageRequested)
    }

    @Test
    fun `render skeleton state - does not request the next page`() = runComposeUiTest {
        val intents = mutableListOf<LikedTracksIntent>()
        setContent(
            state = provider.provideSkeleton(),
            onIntent = intents::add
        )

        waitForIdle()
        intents.shouldBeEmpty()
    }

    private fun ComposeUiTest.setContent(
        state: LikedTracksUIState,
        onIntent: (LikedTracksIntent) -> Unit = {}
    ) {
        setContent {
            ComposeAppTheme {
                LikedTracksScreen(
                    state = state,
                    onIntent = onIntent
                )
            }
        }
    }

    private companion object {
        const val CLICKED_ITEM_INDEX = 1
    }
}
