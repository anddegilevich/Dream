package and.degilevich.dream.shared.feature.search.component.search.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.component.search.impl.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.component.search.impl.preview.SearchUIStatePreviewProvider
import and.degilevich.dream.shared.feature.search.component.search.impl.view.semantic.SearchScreenSemantic
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.v2.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class SearchScreenTest {

    private val provider = SearchUIStatePreviewProvider()

    private val searchField = hasTestTag(SearchScreenSemantic.TEST_TAG_SEARCH_FIELD)
    private val itemSkeleton = hasTestTag(SearchScreenSemantic.TEST_TAG_ITEM_SKELETON)
    private val item = hasTestTag(SearchScreenSemantic.TEST_TAG_ITEM)

    @Test
    fun testSkeletonState() = runComposeUiTest {
        setContent(provider.provideSkeleton())
        checkSearchField()
        onAllNodes(itemSkeleton)
            .onFirst()
            .assertIsDisplayed()
    }

    @Test
    fun testDefaultState() = runComposeUiTest {
        setContent(provider.provideDefault())
        checkSearchField()
        onAllNodes(item).onFirst().assertIsDisplayed()
    }

    private fun ComposeUiTest.checkSearchField() {
        onNode(searchField)
            .assertExists()
            .assertIsDisplayed()
    }

    private fun ComposeUiTest.setContent(state: SearchUIState) = setContent {
        ComposeAppTheme {
            SearchScreen(state = state) {}
        }
    }
}
