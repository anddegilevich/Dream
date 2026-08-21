package and.degilevich.dream.shared.feature.album.component.details.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.component.details.impl.preview.AlbumDetailsUIStatePreviewProvider
import and.degilevich.dream.shared.feature.album.component.details.impl.view.semantic.AlbumDetailsScreenSemantic
import and.degilevich.dream.shared.feature.artist.ui.api.preview.ArtistLabelUIDataPreviewProvider
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
class AlbumDetailsScreenTest {

    private val provider = AlbumDetailsUIStatePreviewProvider()

    private val back = hasTestTag(AlbumDetailsScreenSemantic.TEST_TAG_BACK)
    private val infoSkeleton = hasTestTag(AlbumDetailsScreenSemantic.TEST_TAG_INFO_SKELETON)
    private val info = hasTestTag(AlbumDetailsScreenSemantic.TEST_TAG_INFO)
    private val artistSkeleton = hasTestTag(AlbumDetailsScreenSemantic.TEST_TAG_ARTIST_SKELETON)
    private val artist = hasTestTag(AlbumDetailsScreenSemantic.TEST_TAG_ARTIST)
    private val itemSkeleton = hasTestTag(AlbumDetailsScreenSemantic.TEST_TAG_ITEM_SKELETON)
    private val item = hasTestTag(AlbumDetailsScreenSemantic.TEST_TAG_ITEM)

    @Test
    fun `render skeleton state - shows info artist and item skeletons`() = runComposeUiTest {
        val intents = mutableListOf<AlbumDetailsIntent>()
        setContent(
            state = provider.provideSkeleton(),
            onIntent = intents::add
        )
        onNode(infoSkeleton).assertIsDisplayed()
        onAllNodes(artistSkeleton).onFirst().assertIsDisplayed()
        onAllNodes(itemSkeleton).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render default state - shows info artists and items`() = runComposeUiTest {
        val intents = mutableListOf<AlbumDetailsIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(info).assertIsDisplayed()
        onAllNodes(artist).onFirst().assertIsDisplayed()
        onAllNodes(item).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `click back - emits OnBackClicked`() = runComposeUiTest {
        val intents = mutableListOf<AlbumDetailsIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(back).performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(AlbumDetailsIntent.OnBackClicked)
    }

    @Test
    fun `click artist - emits OnArtistClicked with clicked artist id`() = runComposeUiTest {
        val intents = mutableListOf<AlbumDetailsIntent>()
        val artists = ArtistLabelUIDataPreviewProvider().provideList()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onAllNodes(artist)[CLICKED_ITEM_INDEX].performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(
            AlbumDetailsIntent.OnArtistClicked(id = artists[CLICKED_ITEM_INDEX].id)
        )
    }

    @Test
    fun `click track - emits OnTrackClicked with clicked track id`() = runComposeUiTest {
        val intents = mutableListOf<AlbumDetailsIntent>()
        val tracks = TrackCardUIDataPreviewProvider().provideList()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onAllNodes(item)[CLICKED_ITEM_INDEX].performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(
            AlbumDetailsIntent.OnTrackClicked(id = tracks[CLICKED_ITEM_INDEX].id)
        )
    }

    private fun ComposeUiTest.setContent(
        state: AlbumDetailsUIState,
        onIntent: (AlbumDetailsIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            AlbumDetailsScreen(
                state = state,
                onIntent = onIntent
            )
        }
    }
}

private const val CLICKED_ITEM_INDEX = 1
