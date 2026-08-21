package and.degilevich.dream.shared.feature.common.component.navbar.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarUIState
import and.degilevich.dream.shared.feature.common.component.navbar.impl.preview.NavbarItemUIDataPreviewProvider
import and.degilevich.dream.shared.feature.common.component.navbar.impl.preview.NavbarUIStatePreviewProvider
import and.degilevich.dream.shared.feature.common.component.navbar.impl.view.semantic.AppNavbarSemantic
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
class AppNavbarTest {

    private val provider = NavbarUIStatePreviewProvider()
    private val item = hasTestTag(AppNavbarSemantic.TEST_TAG_ITEM)

    @Test
    fun `render default state - shows items`() = runComposeUiTest {
        val intents = mutableListOf<NavbarIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onAllNodes(item).onFirst().assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `click item - emits OnItemClicked with clicked item id`() = runComposeUiTest {
        val intents = mutableListOf<NavbarIntent>()
        val items = NavbarItemUIDataPreviewProvider().provideList()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onAllNodes(item)[CLICKED_ITEM_INDEX].performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(
            NavbarIntent.OnItemClicked(id = items[CLICKED_ITEM_INDEX].id)
        )
    }

    private fun ComposeUiTest.setContent(
        state: NavbarUIState,
        onIntent: (NavbarIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            AppNavbar(
                state = state,
                onIntent = onIntent
            )
        }
    }
}

private const val CLICKED_ITEM_INDEX = 1
