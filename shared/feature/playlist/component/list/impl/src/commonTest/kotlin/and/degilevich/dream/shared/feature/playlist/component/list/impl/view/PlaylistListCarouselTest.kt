package and.degilevich.dream.shared.feature.playlist.component.list.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.playlist.ui.api.preview.PlaylistCardUIDataPreviewProvider
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListIntent
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListUIState
import and.degilevich.dream.shared.feature.playlist.component.list.impl.preview.PlaylistListUIStatePreviewProvider
import and.degilevich.dream.shared.feature.playlist.component.list.impl.view.semantic.PlaylistListCarouselSemantic
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
class PlaylistListCarouselTest {

    private val provider = PlaylistListUIStatePreviewProvider()

    private val title = hasTestTag(PlaylistListCarouselSemantic.TEST_TAG_TITLE)
    private val likedSongs = hasTestTag(PlaylistListCarouselSemantic.TEST_TAG_LIKED_SONGS)
    private val itemSkeleton = hasTestTag(PlaylistListCarouselSemantic.TEST_TAG_ITEM_SKELETON)
    private val item = hasTestTag(PlaylistListCarouselSemantic.TEST_TAG_ITEM)

    @Test
    fun `render skeleton state - shows title liked songs and item skeletons`() = runComposeUiTest {
        val intents = mutableListOf<PlaylistListIntent>()
        setContent(
            state = provider.provideSkeleton(),
            onIntent = intents::add
        )
        onNode(title).assertIsDisplayed()
        onNode(likedSongs).assertIsDisplayed()
        onAllNodes(itemSkeleton).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render default state - shows title liked songs and items`() = runComposeUiTest {
        val intents = mutableListOf<PlaylistListIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(title).assertIsDisplayed()
        onNode(likedSongs).assertIsDisplayed()
        onAllNodes(item).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `click playlist - emits OnPlaylistClicked with clicked playlist id`() = runComposeUiTest {
        val intents = mutableListOf<PlaylistListIntent>()
        val playlists = PlaylistCardUIDataPreviewProvider().provideList()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onAllNodes(item)[CLICKED_ITEM_INDEX].performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(
            PlaylistListIntent.OnPlaylistClicked(id = playlists[CLICKED_ITEM_INDEX].id)
        )
    }

    @Test
    fun `click liked songs - emits OnLikedSongsClicked`() = runComposeUiTest {
        val intents = mutableListOf<PlaylistListIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(likedSongs).performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(PlaylistListIntent.OnLikedSongsClicked)
    }

    private fun ComposeUiTest.setContent(
        state: PlaylistListUIState,
        onIntent: (PlaylistListIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            PlaylistListCarousel(
                state = state,
                onIntent = onIntent
            )
        }
    }
}

private const val CLICKED_ITEM_INDEX = 1
