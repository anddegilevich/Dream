package and.degilevich.dream.shared.feature.artist.component.details.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.ui.api.preview.AlbumCardUIDataPreviewProvider
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.impl.preview.ArtistDetailsUIStatePreviewProvider
import and.degilevich.dream.shared.feature.artist.component.details.impl.view.semantic.ArtistDetailsScreenSemantic
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
class ArtistDetailsScreenTest {

    private val provider = ArtistDetailsUIStatePreviewProvider()

    private val back = hasTestTag(ArtistDetailsScreenSemantic.TEST_TAG_BACK)
    private val infoSkeleton = hasTestTag(ArtistDetailsScreenSemantic.TEST_TAG_INFO_SKELETON)
    private val info = hasTestTag(ArtistDetailsScreenSemantic.TEST_TAG_INFO)
    private val itemSkeleton = hasTestTag(ArtistDetailsScreenSemantic.TEST_TAG_ITEM_SKELETON)
    private val item = hasTestTag(ArtistDetailsScreenSemantic.TEST_TAG_ITEM)

    @Test
    fun `render skeleton state - shows info and item skeletons`() = runComposeUiTest {
        val intents = mutableListOf<ArtistDetailsIntent>()
        setContent(
            state = provider.provideSkeleton(),
            onIntent = intents::add
        )
        onNode(infoSkeleton).assertIsDisplayed()
        onAllNodes(itemSkeleton).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render default state - shows info and items`() = runComposeUiTest {
        val intents = mutableListOf<ArtistDetailsIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(info).assertIsDisplayed()
        onAllNodes(item).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `click back - emits OnBackClicked`() = runComposeUiTest {
        val intents = mutableListOf<ArtistDetailsIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(back).performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(ArtistDetailsIntent.OnBackClicked)
    }

    @Test
    fun `click album - emits OnAlbumClicked with clicked album id`() = runComposeUiTest {
        val intents = mutableListOf<ArtistDetailsIntent>()
        val albums = AlbumCardUIDataPreviewProvider().provideList()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onAllNodes(item)[CLICKED_ITEM_INDEX].performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(
            ArtistDetailsIntent.OnAlbumClicked(id = albums[CLICKED_ITEM_INDEX].id)
        )
    }

    private fun ComposeUiTest.setContent(
        state: ArtistDetailsUIState,
        onIntent: (ArtistDetailsIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            ArtistDetailsScreen(
                state = state,
                onIntent = onIntent
            )
        }
    }
}

private const val CLICKED_ITEM_INDEX = 1
