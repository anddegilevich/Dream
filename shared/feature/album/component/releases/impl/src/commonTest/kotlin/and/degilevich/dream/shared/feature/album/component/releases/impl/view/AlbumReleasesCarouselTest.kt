package and.degilevich.dream.shared.feature.album.component.releases.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.component.releases.impl.preview.AlbumReleasesUIStatePreviewProvider
import and.degilevich.dream.shared.feature.album.component.releases.impl.view.semantic.AlbumReleasesCarouselSemantic
import and.degilevich.dream.shared.feature.album.ui.api.preview.AlbumCardUIDataPreviewProvider
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
class AlbumReleasesCarouselTest {

    private val provider = AlbumReleasesUIStatePreviewProvider()

    private val title = hasTestTag(AlbumReleasesCarouselSemantic.TEST_TAG_TITLE)
    private val itemSkeleton = hasTestTag(AlbumReleasesCarouselSemantic.TEST_TAG_ITEM_SKELETON)
    private val item = hasTestTag(AlbumReleasesCarouselSemantic.TEST_TAG_ITEM)

    @Test
    fun `render skeleton state - shows title and item skeletons`() = runComposeUiTest {
        val intents = mutableListOf<AlbumReleasesIntent>()
        setContent(
            state = provider.provideSkeleton(),
            onIntent = intents::add
        )
        onNode(title).assertIsDisplayed()
        onAllNodes(itemSkeleton).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render default state - shows title and items`() = runComposeUiTest {
        val intents = mutableListOf<AlbumReleasesIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(title).assertIsDisplayed()
        onAllNodes(item).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `click album - emits OnAlbumClicked with clicked album id`() = runComposeUiTest {
        val intents = mutableListOf<AlbumReleasesIntent>()
        val albums = AlbumCardUIDataPreviewProvider().provideList()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onAllNodes(item)[CLICKED_ITEM_INDEX].performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(
            AlbumReleasesIntent.OnAlbumClicked(id = albums[CLICKED_ITEM_INDEX].id)
        )
    }

    private fun ComposeUiTest.setContent(
        state: AlbumReleasesUIState,
        onIntent: (AlbumReleasesIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            AlbumReleasesCarousel(
                state = state,
                onIntent = onIntent
            )
        }
    }
}

private const val CLICKED_ITEM_INDEX = 1
