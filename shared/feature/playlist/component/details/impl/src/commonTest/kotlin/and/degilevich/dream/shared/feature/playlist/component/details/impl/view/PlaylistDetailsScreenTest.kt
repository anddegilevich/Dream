package and.degilevich.dream.shared.feature.playlist.component.details.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsIntent
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsUIState
import and.degilevich.dream.shared.feature.playlist.component.details.impl.preview.PlaylistDetailsUIStatePreviewProvider
import and.degilevich.dream.shared.feature.playlist.component.details.impl.view.semantic.PlaylistDetailsScreenSemantic
import and.degilevich.dream.shared.feature.playlist.ui.api.preview.PlaylistTrackCardUIDataPreviewProvider
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
class PlaylistDetailsScreenTest {

    private val provider = PlaylistDetailsUIStatePreviewProvider()

    private val back = hasTestTag(PlaylistDetailsScreenSemantic.TEST_TAG_BACK)
    private val headerSkeleton = hasTestTag(PlaylistDetailsScreenSemantic.TEST_TAG_HEADER_SKELETON)
    private val cover = hasTestTag(PlaylistDetailsScreenSemantic.TEST_TAG_COVER)
    private val name = hasTestTag(PlaylistDetailsScreenSemantic.TEST_TAG_NAME)
    private val description = hasTestTag(PlaylistDetailsScreenSemantic.TEST_TAG_DESCRIPTION)
    private val count = hasTestTag(PlaylistDetailsScreenSemantic.TEST_TAG_COUNT)
    private val countSkeleton = hasTestTag(PlaylistDetailsScreenSemantic.TEST_TAG_COUNT_SKELETON)
    private val item = hasTestTag(PlaylistDetailsScreenSemantic.TEST_TAG_ITEM)
    private val itemSkeleton = hasTestTag(PlaylistDetailsScreenSemantic.TEST_TAG_ITEM_SKELETON)
    private val nextPageSkeleton = hasTestTag(PlaylistDetailsScreenSemantic.TEST_TAG_NEXT_PAGE_SKELETON)

    @Test
    fun `render skeleton state - shows header count and item skeletons`() = runComposeUiTest {
        setContent(state = provider.provideSkeleton())

        onNode(headerSkeleton).assertIsDisplayed()
        onNode(countSkeleton).assertIsDisplayed()
        onAllNodes(itemSkeleton).onFirst().assertIsDisplayed()
    }

    @Test
    fun `render default state - shows cover name description count and items`() = runComposeUiTest {
        setContent(state = provider.provideDefault())

        onNode(cover).assertIsDisplayed()
        onNode(name).assertIsDisplayed()
        onNode(description).assertIsDisplayed()
        onNode(count).assertIsDisplayed()
        onAllNodes(item).onFirst().assertIsDisplayed()
    }

    @Test
    fun `render state without description - shows cover and name but no description`() = runComposeUiTest {
        setContent(state = provider.provideWithoutDescription())

        onNode(cover).assertIsDisplayed()
        onNode(name).assertIsDisplayed()
        onAllNodes(description).fetchSemanticsNodes().shouldBeEmpty()
    }

    @Test
    fun `render loading next page state - shows items and next page skeleton`() = runComposeUiTest {
        setContent(state = provider.provideLoadingNextPage())

        onAllNodes(item).onFirst().assertIsDisplayed()
        onAllNodes(nextPageSkeleton).onFirst().assertIsDisplayed()
    }

    @Test
    fun `click back - emits OnBackClicked`() = runComposeUiTest {
        val intents = mutableListOf<PlaylistDetailsIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onNode(back).performClick()

        waitUntil(conditionDescription = "intent emitted") {
            intents.contains(PlaylistDetailsIntent.OnBackClicked)
        }
    }

    @Test
    fun `click track - emits OnTrackClicked with clicked track id`() = runComposeUiTest {
        val intents = mutableListOf<PlaylistDetailsIntent>()
        val tracks = PlaylistTrackCardUIDataPreviewProvider().provideList()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        onAllNodes(item)[CLICKED_ITEM_INDEX].performClick()

        waitUntil(conditionDescription = "intent emitted") {
            intents.any { intent -> intent is PlaylistDetailsIntent.OnTrackClicked }
        }
        intents.filterIsInstance<PlaylistDetailsIntent.OnTrackClicked>()
            .shouldContainExactly(
                PlaylistDetailsIntent.OnTrackClicked(id = tracks[CLICKED_ITEM_INDEX].id)
            )
    }

    @Test
    fun `render short list - requests the next page once the end is reached`() = runComposeUiTest {
        val intents = mutableListOf<PlaylistDetailsIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )

        waitUntil(conditionDescription = "next page requested") {
            intents.contains(PlaylistDetailsIntent.OnNextPageRequested)
        }
        intents.shouldContainExactly(PlaylistDetailsIntent.OnNextPageRequested)
    }

    @Test
    fun `render skeleton state - does not request the next page`() = runComposeUiTest {
        val intents = mutableListOf<PlaylistDetailsIntent>()
        setContent(
            state = provider.provideSkeleton(),
            onIntent = intents::add
        )

        waitForIdle()
        intents.shouldBeEmpty()
    }

    private fun ComposeUiTest.setContent(
        state: PlaylistDetailsUIState,
        onIntent: (PlaylistDetailsIntent) -> Unit = {}
    ) {
        setContent {
            ComposeAppTheme {
                PlaylistDetailsScreen(
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
